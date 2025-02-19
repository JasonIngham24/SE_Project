package seproject;

public class SourceHandlerImpl {
	boolean isNetworkLocation;
	boolean isLocalFile; 
	
	public SourceHandlerImpl(boolean isNetworkLocation, boolean isLocalFile) {
		this.isNetworkLocation = isNetworkLocation;
		this.isLocalFile = isLocalFile;
	}
	
	public boolean checkNetworkLocation() { 
		return this.isNetworkLocation; 
	}
	
	public boolean checkLocalFile() {
		return this.isLocalFile; 
	}
	

}
