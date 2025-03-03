package seproject.apis.computestore;
import annotations.ProcessAPI;

@ProcessAPI
//interface to handle different types of input sources 
public interface SourceHandler {
	boolean isNetworkLocation(String source); 
	boolean isLocalFile(String source);

	String readIntegers(String inputSource);
	String getDelimiter(); 
	String setSource(); 
	String setDelimiter(); 
	

	String getDLim();
	int getSource(); 


}
