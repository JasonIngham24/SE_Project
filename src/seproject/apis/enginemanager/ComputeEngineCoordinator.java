package seproject.apis.enginemanager;

import java.util.ArrayList;
import java.util.List;

import seproject.UserComputeEngineImpl;
import seproject.apis.datastorage.DataStorageAPI;

public class ComputeEngineCoordinator {

	private final DataStorageAPI dataStorage; 
	private final EngineManagerAPI engineManager; 
	private final UserComputeEngineImpl userComputeEngine; 

	public ComputeEngineCoordinator(DataStorageAPI ds, UserComputeEngineImpl uc, EngineManagerAPI em) {
		this.dataStorage = ds; 
		this.engineManager = em; 
		this.userComputeEngine = uc; 
	}

	/*
	 * Method to start computation process. 
	 * Receives input location, processes the computation, and writes results 
	 * @param inputSource --> source location for input data 
	 */

	public String startComputation(String inputSource, String outputDest) { 
		//step 1 - set up the input source 
		userComputeEngine.sendInputSource(inputSource, ","); 

		//step 2 - set up output source 
		userComputeEngine.sendOutputDest(outputDest);

		//step 3 - request data storage to read Integers from the source location
		List<Integer> numbers = userComputeEngine.getInput(inputSource); 
		if (numbers == null || numbers.isEmpty()) {
			return "Failed to read integers from input source"; 
		}

		//step 4: pass integers to the compute component and get results 
		List<Integer> results = computeResults(numbers);

		//step 5 
		boolean writeSuccess = dataStorage.writeData(outputDest, formatResults(results));
		if (!writeSuccess) { 
			return "Failed to write results to the destination.";
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
		for (Integer number : numbers) { 
			engineManager.setData(number);
			int result = engineManager.sumOfNthEvenFibbonaciNums(number); 
			results.add(result); 
		}

		return results; 
	}
	
	
	/*
	 * Helper method to format the results of the results to be sent to data storage 
	 */
	
	private String formatResults(List<Integer> results) { 
		StringBuilder formattedResults = new StringBuilder(); 
		for (Integer result : results) {
			formattedResults.append(result).append("\n"); 
		}
		
		return formattedResults.toString(); 
	}
}