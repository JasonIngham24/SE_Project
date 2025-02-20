package seproject.apis.computeStore;
import project.annotations.ProcessAPI;

@ProcessAPI
//interface to handle different types of input sources 
public interface SourceHandler {
	boolean isNetworkLocation(String source); 
	boolean isLocalFile(String source); 

}
