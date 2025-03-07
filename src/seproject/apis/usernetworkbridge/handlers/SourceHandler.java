package seproject.apis.usernetworkbridge.handlers;
import java.util.List;

import annotations.ProcessAPI;

@ProcessAPI
//interface to handle different types of input sources 
public interface SourceHandler {
	boolean isNetworkLocation(String source); 
	boolean isLocalFile(String source);

	List<Integer> readIntegers();
	String getDelimiter(); 
	String setSource(); 
	String setDelimiter(); 
	

	String getDLim();
	int getSource(); 


}
