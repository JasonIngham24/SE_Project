package seproject.apis.usernetworkbridge;
import annotations.NetworkAPI;
import annotations.ProcessAPIPrototype;
import seproject.apis.computestore.SourceHandler;
import seproject.apis.computestore.StorageHandler;

@NetworkAPI
public interface UserComputeEngineAPI {
	
	@ProcessAPIPrototype
	//public InputProcessor processInputData(String source, String delimiter, String dest);

	public SourceHandler sendInputSource(String source, String delimiter);

	public StorageHandler sendOutputDest(String dest); 
	
	


}
