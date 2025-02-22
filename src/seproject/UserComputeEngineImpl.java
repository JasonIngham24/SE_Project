package seproject;

import seproject.apis.computestore.SourceHandler;
import seproject.apis.enginemanager.StorageHandler;

public class UserComputeEngineImpl {
	
	private SourceHandler sourceHandler; 
	private StorageHandler storageHandler; 
	

	public UserComputeEngineImpl(SourceHandler sourceHandler, StorageHandler storageHandler) {
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

}
