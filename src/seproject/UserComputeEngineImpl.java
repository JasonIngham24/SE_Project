package seproject;

import java.util.ArrayList;
import java.util.List;

import seproject.apis.usernetworkbridge.handlers.SourceHandler;
import seproject.apis.usernetworkbridge.handlers.StorageHandler;

public class UserComputeEngineImpl {
	
	private SourceHandler sourceHandler; 
	private StorageHandler storageHandler; 
	 
	

	public UserComputeEngineImpl(SourceHandler sourceHandler, StorageHandler storageHandler){
		this.sourceHandler = sourceHandler; 
		this.storageHandler = storageHandler; 
	}
	

	//issue - change to setInputSource to get input (for now, local file) from the user 
	public SourceHandler sendInputSource(String source, String delimiter) {
		System.out.print("sendInputSource called with source: " + source + "and delimiter: " + delimiter);
		return sourceHandler; 
	}
	

	//issue - change to setOutputDest to read in the output destination from user 
	public StorageHandler sendOutputDest(String dest) {
		System.out.println("sendOutputDest called with dest: " + dest); 
		return storageHandler; 
	}
	


	/*
	 * getInput 
	 * Method to retrieve file from sourcehandler and read in the integers to be processed 
	 */
	public List<Integer> getInput() {
		List<Integer> numbers = new ArrayList<>(); 
		
		List<Integer> results = sourceHandler.readIntegers(); 
			for (Integer result : results) {
				try {
					numbers.add(result); 
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format: " + results);
				}
			}
		
		
		return numbers; 
	}

}
