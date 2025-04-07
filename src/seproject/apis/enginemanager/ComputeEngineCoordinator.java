package seproject.apis.enginemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import seproject.UserComputeEngineImpl;
import seproject.apis.datastorage.DataStorageAPI;
import seproject.exceptions.ComputationException;



public class ComputeEngineCoordinator {

	private final DataStorageAPI dataStorage; 
	private final EngineManagerAPI engineManager;
	private final implementations.UserComputeEngineImpl userComputeEngine; 

	public ComputeEngineCoordinator(DataStorageAPI ds, implementations.UserComputeEngineImpl engine, EngineManagerAPI em) {
		this.dataStorage = ds; 
		this.userComputeEngine = engine; 
		this.engineManager = em; 
	}

	/*
	 * Method to start computation process. 
	 * Receives input location, processes the computation, and writes results 
	 * @param inputSource --> source location for input data 
	 * @param outputDest --> where the results of the computation will be sent to upon completion 
	 * @param delimiter --> delimiter we will use to help format results data 
	 */

	
	public String startComputation(String inputSource, String outputDest, char delimiter) throws ComputationException { 
		try {
			//Validate Input parameters 
			if (inputSource == null || inputSource.trim().isEmpty()) {
				throw new ComputationException("Invalid input source provided."); 
			}

			if (outputDest == null || outputDest.trim().isEmpty()) {
				throw new ComputationException("Invalid output destination provided."); 
			}

			//step 1 - set up the input source 
			userComputeEngine.sendInputSource(inputSource, delimiter); 

			//step 2 - set up output source 
			userComputeEngine.sendOutputDest(outputDest);

			//step 3 - request data storage to read Integers from the source location
			List<Integer> numbers = userComputeEngine.getInput(); 
			
			if (numbers == null || numbers.isEmpty()) {
				throw new ComputationException("Failed to read integers from the input source."); 
			}

			//step 4: pass integers to the compute component and get results 
			List<Integer> results = computeResults(numbers);

			//step 5 --> request/confirm that the results have been successfully written to the data storage location 
			boolean writeSuccess = dataStorage.writeData(outputDest, formatResults(results));
			if (!writeSuccess) { 
				throw new ComputationException("Failed to write results to the destination."); 
			}
		} catch (ComputationException e) {
			throw e; 
		} catch (Exception e) {
			throw new ComputationException("An unexpected error occurred during computation."); 
		}

		return "Computation completed successfully."; 
	}

	/*
	 * Helper method to perform computation on the list of Integers 
	 * @param numbers - The list of integers to compute 
	 * @return a list of computed results 
	 * 
	 */

	private List<Integer> computeResults(List<Integer> numbers) { 
		List<Integer> results = new ArrayList<>(); 
		//using available processors to ensure we do not overload the user's system
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		List<Future<Integer>> futures = new ArrayList<>(); 
		try {
			//implement multithreading at this phase - Sean E 
			for (Integer number : numbers) { 
				Future<Integer> future = executor.submit(() -> engineManager.sumOfNthEvenFibbonaciNums(number));  
				futures.add(future); 
			}
		} catch (Exception e) {
			throw new RuntimeException("Error during computation" + e.getMessage());
		}
		
		for(Future<Integer> future : futures) { 
			try {
				results.add(future.get()); 
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace(); 
				results.add(-1); 
			}
		}
		executor.shutdown();
		return results; 
	}



	/*
	 * Helper method to format the results of the results to be sent to data storage 
	 * @param results - raw results from computation to be formatted 
	 * @return Integer list of calculated results 
	 */

	private String formatResults(List<Integer> results) { 
		try {
			StringBuilder formattedResults = new StringBuilder(); 
			for (Integer result : results) {
				formattedResults.append(result).append("\n"); 
			}

			return formattedResults.toString(); 
		} catch (Exception e) {
			throw new RuntimeException("Error formatting results " + e.getMessage());
		}

	}
}