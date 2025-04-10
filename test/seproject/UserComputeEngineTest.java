package seproject;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import implementations.UserComputeEngineImpl;
import seproject.apis.usernetworkbridge.handlers.SourceHandlerImpl;
import seproject.apis.usernetworkbridge.handlers.StorageHandlerImpl;




public class UserComputeEngineTest {
    
    @InjectMocks 
    private UserComputeEngineImpl userComputeEngine; 
    
    @Mock 
    private SourceHandlerImpl mockSourceHandler; 
    
    @Mock
    private StorageHandlerImpl mockStorageHandler; 
    
    @BeforeEach
    void setUp() {  
        MockitoAnnotations.openMocks(this); 
        mockSourceHandler = Mockito.mock(SourceHandlerImpl.class);  // Ensure mock is set up before use
        mockStorageHandler = Mockito.mock(StorageHandlerImpl.class);
        userComputeEngine = new UserComputeEngineImpl(mockSourceHandler, mockStorageHandler);
    }
    
    @Test 
    void testConstructor() {
        Assertions.assertNotNull(userComputeEngine);
    }
    
    @Test 
    void testSendInputSource() {
        String source = "inputData"; 
        char delimiter = ','; // Corrected delimiter type
        
        Mockito.when(mockSourceHandler.toString()).thenReturn("Mocked SourceHandler");
        
        SourceHandlerImpl result = userComputeEngine.sendInputSource(source, delimiter); 
        
        Assertions.assertEquals(mockSourceHandler, result);
    }
    
    @Test 
    void testSendOutputDest() { 
        String dest = "outputLocation"; 
        
        Mockito.when(mockStorageHandler.toString()).thenReturn("Mocked StorageHandler"); 
    
        StorageHandlerImpl result = userComputeEngine.sendOutputDest(dest); 
        
        Assertions.assertEquals(mockStorageHandler, result);
    }
    
    @Test 
    void testGetInput_withValidData() {
        try {
			Mockito.when(mockSourceHandler.readIntegers()).thenReturn(Arrays.asList(1, 2, 3, 4, 5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Mockito.when(mockSourceHandler.getDelimiter()).thenReturn(',');
    
        List<Integer> result = userComputeEngine.getInput(); // Removed argument
    
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result); 
    }
    
    @Test 
    void testGetInput_withInvalidData() { 
        try {
			Mockito.when(mockSourceHandler.readIntegers()).thenReturn(Arrays.asList(1, 3, 5));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Mockito.when(mockSourceHandler.getDelimiter()).thenReturn(','); 
        
        List<Integer> result = userComputeEngine.getInput(); // Removed argument
        
        assertEquals(Arrays.asList(1, 3, 5), result); 
    }
    
    @Test 
    void testGetInput_withEmptyData() {  
        try {
			Mockito.when(mockSourceHandler.readIntegers()).thenReturn(new ArrayList<Integer>());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Mockito.when(mockSourceHandler.getDelimiter()).thenReturn(','); 
        
        List<Integer> result = userComputeEngine.getInput(); // Removed argument
        
        assertTrue(result.isEmpty());
    }
}
	
	
	
	
	


