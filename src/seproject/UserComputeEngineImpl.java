package seproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import seproject.apis.usernetworkbridge.handlers.SourceHandler;
import seproject.apis.usernetworkbridge.handlers.SourceHandlerImpl;
import seproject.apis.usernetworkbridge.handlers.StorageHandler;
import seproject.apis.usernetworkbridge.handlers.StorageHandlerImpl;

public class UserComputeEngineImpl {
	
	private SourceHandlerImpl sourceHandler; 
	private StorageHandlerImpl storageHandler; 
	 
	

	public UserComputeEngineImpl(SourceHandlerImpl sourceHandlerImpl, StorageHandlerImpl storageHandlerImpl){
		this.sourceHandler = sourceHandlerImpl; 
		this.storageHandler = storageHandlerImpl; 
	}
	

	//issue - change to setInputSource to get input (for now, local file) from the user 
	public SourceHandlerImpl sendInputSource(String source, char delimiter) {
		System.out.print("sendInputSource called with source: " + source + "and delimiter: " + delimiter);
		return sourceHandler; 
	}
	

	//issue - change to setOutputDest to read in the output destination from user 
	public StorageHandlerImpl sendOutputDest(String dest) {
		System.out.println("sendOutputDest called with dest: " + dest); 
		return storageHandler; 
	}
	


	/*
	 * getInput 
	 * Method to retrieve file from sourcehandler and read in the integers to be processed 
	 */
	public List<Integer> getInput() {
		List<Integer> numbers = new ArrayList<>(); 
		
		List<Integer> results = null;
		try {
			results = sourceHandler.readIntegers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
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
