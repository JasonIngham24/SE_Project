package seproject;

public class UserComputeEngineImpl {
	
	private SourceHandler sourceHandler; 
	private StorageHandler storageHandler; 
	
	//smoke tests to be created for constructor 
	public UserComputeEngineImpl(SourceHandler sourceHandler, StorageHandler storageHandler) {
		this.sourceHandler = sourceHandler; 
		this.storageHandler = storageHandler; 
	}
	
	//smoke test for sendInputSource
	public SourceHandler sendInputSource(String source, String delimiter) {
		System.out.print("sendInputSource called with source: " + source + "and delimiter: " + delimiter);
		return sourceHandler; 
	}
	
	//smoke test for sendOutputDest 
	public StorageHandler sendOutputDest(String dest) {
		System.out.println("sendOutputDest called with dest: " + dest); 
		return storageHandler; 
	}

}
