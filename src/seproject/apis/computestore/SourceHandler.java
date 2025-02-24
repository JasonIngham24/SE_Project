package seproject.apis.computestore;
import project.annotations.ProcessAPI;

@ProcessAPI
//interface to handle different types of input sources 
public interface SourceHandler {
	boolean isNetworkLocation(String source); 
	boolean isLocalFile(String source);
	String getDLim();
	int getSource(); 

}
