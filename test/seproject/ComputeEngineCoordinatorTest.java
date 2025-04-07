package seproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import seproject.apis.datastorage.DataStorageAPI;
import seproject.apis.enginemanager.ComputeEngineCoordinator;
import seproject.apis.enginemanager.EngineManagerAPI;
import seproject.exceptions.ComputationException;
import implementations.UserComputeEngineImpl;



public class ComputeEngineCoordinatorTest {

	@InjectMocks 
	private UserComputeEngineImpl engine; 

	@Mock 
	private DataStorageAPI storage; 

	@Mock 
	private EngineManagerAPI manager;

	@Mock 
	private ComputeEngineCoordinator coordinator; 



	@BeforeEach 
	void setUp() {
	    MockitoAnnotations.openMocks(this);
	    coordinator = new ComputeEngineCoordinator(storage, engine, manager);
	}

	
	@Test
	void testStartComputationHandlesComputationFailure() {
		try {
			//Simulate successful input retrieval 
			when(engine.getInput()).thenReturn(Arrays.asList(1, 2, 3)); 

			//Simulate computation failure 
			when(manager.sumOfNthEvenFibbonaciNums(anyInt())).thenThrow(new RuntimeException("Computation Error"));

			//Verify that the computation error is caught and translated into error message 
			String result = coordinator.startComputation("validInput", "validOutput", ',');
			assertEquals("An unexpected error occurred: Computation error", result);
		} catch (ComputationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	@Test 
	void testStartComputationHandlesGetInputFailure() {
		try {
			//Mock getInput() throwing an exception
			when(engine.getInput()).thenThrow(new RuntimeException("Data retrieval failed")); 

			//Verify exception is handled and transformed into a meaningful return message
			String result = coordinator.startComputation("validInput", "validOutput", ',');
			assertEquals("An unexpected error occurred: Data retrieval failed", result); 
		} catch (ComputationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


	@Test 
	void testStartComputationHandlesWriteFailure() { 
		try {
			//Simulate successful input retrieval and computation
			when(engine.getInput()).thenReturn(Arrays.asList(1, 2, 3)); 
			when(manager.sumOfNthEvenFibbonaciNums(anyInt())).thenReturn(10);

			//Simulate write failure 
			when(storage.writeData(anyString(), anyString())).thenReturn(false);

			//Verify that failure is handled properly 
			String result = coordinator.startComputation("validInput", "validOutput", ',');
			assertEquals("Failed to write results to the destination", result); 
		} catch (ComputationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/*
	 * testStartComputation
	 * Test function to ensure parameter verification works as expected
	 */
	@Test
	void testStartComputationThrowsException() {
	    assertThrows(ComputationException.class, () -> {
	        coordinator.startComputation("validInput", "invalidOutput", ',');
	    });
	}




}
