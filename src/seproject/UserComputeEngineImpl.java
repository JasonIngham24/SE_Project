package seproject;

import java.util.ArrayList;
import java.util.List;

import seproject.apis.computestore.SourceHandler;
import seproject.apis.computestore.StorageHandler;

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
	public List<Integer> getInput(String inputSource) {
		List<Integer> numbers = new ArrayList<>(); 
		
		String rawData = sourceHandler.readIntegers(inputSource); 
		if (rawData != null && !rawData.isEmpty()) {
			String [] parts = rawData.split(sourceHandler.getDelimiter()); 
			for (String part : parts) {
				try {
					numbers.add(Integer.parseInt(part.trim())); 
				} catch (NumberFormatException e) {
					System.out.println("Invalid number format: " + part);
				}
			}
		}
		
		return numbers; 
	}

}
