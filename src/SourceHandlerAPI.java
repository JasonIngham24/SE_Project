@ProcessAPI
//interface to handle different types of input sources 
public interface SourceHandlerAPI {
	boolean isNetworkLocation(String source); 
	boolean isLocalFile(String source); 

}
