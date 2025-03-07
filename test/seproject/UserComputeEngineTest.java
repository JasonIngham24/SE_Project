package seproject;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import seproject.apis.computestore.SourceHandler;
import seproject.apis.computestore.StorageHandler;



public class UserComputeEngineTest {
	
	//Test class for UserComputeEngineImpl 

	@InjectMocks 
	private UserComputeEngineImpl userComputeEngine; 
	
	@Mock 
	private SourceHandler mockSourceHandler; 
	
	@Mock
	private StorageHandler mockStorageHandler; 
	
	@BeforeEach
	void setUp() {  
		MockitoAnnotations.openMocks(this); 
		userComputeEngine = new UserComputeEngineImpl(mockSourceHandler, mockStorageHandler); 
		mockSourceHandler = Mockito.mock(SourceHandler.class);
	}
	
	@Test 
	void testConstructor() {
		Assertions.assertNotNull(userComputeEngine);
	}
	
	@Test 
	void testSendInputSource() {
		String source = "inputData"; 
		String delimiter = ","; 
		
		Mockito.when(mockSourceHandler.toString()).thenReturn("Mocked SourceHandler");
		
		SourceHandler result = userComputeEngine.sendInputSource(source, delimiter); 
		
		Assertions.assertEquals(mockSourceHandler, result);
	}
	
	@Test 
	void testSendOutputDest() { 
		String dest = "outputLocation"; 
		
		Mockito.when(mockStorageHandler.toString()).thenReturn("Mocked StorageHandler"); 

		StorageHandler result = userComputeEngine.sendOutputDest(dest); 
		
		Assertions.assertEquals(mockStorageHandler, result);
	}
	
	@Test 
	void testGetInput_withValidData() {
		String testData = "1, 2, 3, 4, 5"; 
		Mockito.when(mockSourceHandler.readIntegers("testSource")).thenReturn(testData);
		Mockito.when(mockSourceHandler.getDelimiter()).thenReturn(","); 
		
		List<Integer> result = userComputeEngine.getInput("testSource"); 
		
		assertEquals(Arrays.asList(1, 2, 3, 4, 5), result); 
	}
	
	@Test 
	void testGetInput_withInvalidData() { 
		String testData = "1, a, 3, b, 5"; 
		Mockito.when(mockSourceHandler.readIntegers("testSource")).thenReturn(testData);
		Mockito.when(mockSourceHandler.getDelimiter()).thenReturn(","); 
		
		List<Integer> result = userComputeEngine.getInput("testSource"); 
		
		assertEquals(Arrays.asList(1, 3, 5), result); 
	}
	
	@Test 
	void testGetInput_withEmptyData() {  
		Mockito.when(mockSourceHandler.readIntegers("testSource")).thenReturn("");
		Mockito.when(mockSourceHandler.getDelimiter()).thenReturn(","); 
		
		List<Integer> result = userComputeEngine.getInput("testSource"); 
		
		assertTrue(result.isEmpty());
	}
	
	
	
	
	

}
