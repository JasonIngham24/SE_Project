package seproject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import seproject.apis.computestore.SourceHandler;
import seproject.apis.enginemanager.StorageHandler;

//@ExtendWith(MockitoExtension.class)
public class UserComputeEngineTest {
	
	//Test class for UserComputeEngineImpl 
	//@InjectMocks 
	private UserComputeEngineImpl userComputeEngine; 
	
	//@Mock 
	private SourceHandler mockSourceHandler; 
	
	//@Mock
	private StorageHandler mockStorageHandler; 
	
	@BeforeEach
	void setUp() { 
		//MockitoAnnotations.openMocks(this); 
		userComputeEngine = new UserComputeEngineImpl(mockSourceHandler, mockStorageHandler); 
	}
	
	@Test 
	void testConstructor() {
		Assertions.assertNotNull(userComputeEngine);
	}
	
	@Test 
	void testSendInputSource() {
		String source = "inputData"; 
		String delimiter = ","; 
		
		//Mockito.when(mockSourceHandler.toString()).thenReturn("Mocked SourceHandler");
		
		SourceHandler result = userComputeEngine.sendInputSource(source, delimiter); 
		
		Assertions.assertEquals(mockSourceHandler, result);
	}
	
	@Test 
	void testSendOutputDest() { 
		String dest = "outputLocation"; 
		
		//Mockito.when(mockStorageHandler.toString()).thenReturn("Mocked StorageHandler"); 
		
		StorageHandler result = userComputeEngine.sendOutputDest(dest); 
		
		Assertions.assertEquals(mockStorageHandler, result);
	}

}
