package implementations;

import java.io.IOException;
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
	

	
	public SourceHandler sendInputSource(String source, char delimiter) {
		System.out.print("sendInputSource called with source: " + source + "and delimiter: " + delimiter);
		return sourceHandler; 
	}
	


	public StorageHandler sendOutputDest(String dest) {
		System.out.println("sendOutputDest called with dest: " + dest); 
		return storageHandler; 
	}
	



	public List<Integer> getInput() {
		List<Integer> numbers = new ArrayList<>(); 
		
		List<Integer> results = null;
		results = sourceHandler.readIntegers(); 
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
