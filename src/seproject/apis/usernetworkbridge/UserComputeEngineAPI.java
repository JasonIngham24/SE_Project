package seproject.apis.usernetworkbridge;
import project.annotations.NetworkAPI;
import project.annotations.ProcessAPIPrototype;
import seproject.apis.computestore.SourceHandler;
import seproject.apis.enginemanager.StorageHandler;

@NetworkAPI
public interface UserComputeEngineAPI {
	
	@ProcessAPIPrototype
	//public InputProcessor processInputData(String source, String delimiter, String dest);

	public SourceHandler sendInputSource(String source, String delimiter);

	public StorageHandler sendOutputDest(String dest); 
	
	


}
