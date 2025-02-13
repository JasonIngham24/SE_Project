
//import java.lang.NumberFormatException;
import java.io.*; 
import java.nio.file.*; 
import java.net.*; 
import java.util.Scanner; 

public class Prototype{
	
	
	@NetworkAPIPrototype
	public void prototype(UserComputeEngineAPI api) {
		Scanner scanner = new Scanner(System.in); 
		
		// get input source from the user 
		System.out.println("Enter Input Source");
		String source = scanner.nextLine(); 
		
		//get output destination
		System.out.println("Enter output destination");
		String dest = scanner.nextLine(); 
		
		//get delimiter 
		System.out.println("Enter delimiter");
		String delimiter = scanner.nextLine(); 
		
		/*
		System.out.println("Iteration of Sequence: " + num);
		System.out.println("Delimiter: " + delimiter); 
		System.out.println("Output Location: " + dest); 
		*/
		
		//default delimiter if user chooses not to specify 
		if (delimiter == null || delimiter.isEmpty()) {
			delimiter = ","; 
		}
		
		if (isLocalFile(source)) {
			System.out.println("Local file detected"); 
		} else if (isNetworkLocation(source)) {
			System.out.println("Network location detected"); 
		} else {
			System.out.print("Unknown source type");
		}
		
		api.processInputData(source, delimiter, dest);
		
		
		
	}
	
	//method to check validity of specified network location 
	//throws exception if URL is invalid 
	public boolean isNetworkLocation(String source) {
		try { 
			new URL(source); 
			return true;
		} catch(MalformedURLException e) {
			return false; 
		}
	}
	
	//method to confirm if input source is local file 
	public boolean isLocalFile(String source) {
		return Files.exists(Paths.get(source)); //does file exist locally? 
	}
	
}
