package seproject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import implementations.EngineManagerImpl;
import implementations.FileBasedDataStorageImpl;
import implementations.UserComputeEngineImpl;
import seproject.apis.datastorage.DataStorageAPI;
import seproject.apis.enginemanager.ComputeEngineCoordinator;
import seproject.apis.enginemanager.EngineManagerAPI;
import seproject.apis.usernetworkbridge.handlers.SourceHandlerImpl;
import seproject.apis.usernetworkbridge.handlers.StorageHandlerImpl;


public class TestMultiUser {
    
    private ComputeEngineCoordinator coordinator;
    
    @BeforeEach
    public void initializeComputeEngine() {
        DataStorageAPI dataStorage = new FileBasedDataStorageImpl(); 
        EngineManagerAPI engineManager = new EngineManagerImpl(0); 
        UserComputeEngineImpl userComputeEngine = new UserComputeEngineImpl(
        	    SourceHandlerImpl.createLocalFileHandler("file:///C:/Users/jclic/OneDrive/Documents/GitHub/SE_Project/test/seproject/testInputFile.csv", ','),
        	    new StorageHandlerImpl());

        coordinator = new ComputeEngineCoordinator(dataStorage, userComputeEngine, engineManager); 
    }
    
    @Test
    public void compareMultiAndSingleThreaded() throws Exception {
        int threadCount = 4;
        List<TestUser> testUsers = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            testUsers.add(new TestUser(coordinator));
        }
        
        // Run single threaded
        String singleThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.singleThreadOut.tmp";
        for (int i = 0; i < threadCount; i++) {
            File singleThreadedOut = new File(singleThreadFilePrefix + i);
            singleThreadedOut.deleteOnExit();
            testUsers.get(i).run(singleThreadedOut.getCanonicalPath());
        }
        
        // Run multi threaded
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<Future<?>> results = new ArrayList<>();
        String multiThreadFilePrefix = "testMultiUser.compareMultiAndSingleThreaded.test.multiThreadOut.tmp";
        for (int i = 0; i < threadCount; i++) {
            File multiThreadedOut = new File(multiThreadFilePrefix + i);
            multiThreadedOut.deleteOnExit();
            String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
            TestUser testUser = testUsers.get(i);
            results.add(threadPool.submit(() -> testUser.run(multiThreadOutputPath)));
        }
        
        results.forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        
        // Check that the output is the same for multi-threaded and single-threaded
        List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, threadCount);
        List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, threadCount);
        Assert.assertEquals(singleThreaded, multiThreaded);
    }
    
    private List<String> loadAllOutput(String prefix, int threadCount) throws IOException {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            File multiThreadedOut = new File(prefix + i);
            if (!multiThreadedOut.exists()) {
                System.err.println("[ERROR] Output file not found: " + multiThreadedOut.getAbsolutePath());
                throw new IOException("Missing output file: " + multiThreadedOut.getAbsolutePath());
            }
            System.out.print("Checking file: " + multiThreadedOut.getAbsolutePath());
            result.addAll(Files.readAllLines(multiThreadedOut.toPath()));
        }
        
        return result;
    }
}
