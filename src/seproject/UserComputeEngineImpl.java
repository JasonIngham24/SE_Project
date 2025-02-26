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
	

	
	public SourceHandler sendInputSource(String source, String delimiter) {
		System.out.print("sendInputSource called with source: " + source + "and delimiter: " + delimiter);
		return sourceHandler; 
	}
	


	public StorageHandler sendOutputDest(String dest) {
		System.out.println("sendOutputDest called with dest: " + dest); 
		return storageHandler; 
	}



	public List<Integer> getInput(String inputSource) {
		List<Integer> numbers = new ArrayList<>(); 
		
		String rawData = sourceHandler.readData(inputSource); 
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
