@NetworkAPI
public interface UserComputeEngineAPI {
	
	@ProcessAPIPrototype
	public InputProcessor processInputData(String source, String delimiter, String dest); 


}
