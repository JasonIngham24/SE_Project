package se_project;

@NetworkAPI
public interface UserComputeEngineAPI {
	
	@ProcessAPIPrototype
	//public InputProcessor processInputData(String source, String delimiter, String dest);

	public SourceHandler sendInputSource(String source, String delimiter);

	public StorageHandler sendOutputDest(String dest); 
	
	


}
