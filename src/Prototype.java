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
	
	/*
	public static void main(String [] args) {
		//getting user input from the command line 
		//issue - implement local file reading
	
		if (args.length != 3) { //expecting 3 arguments: a(n) (long?) int for the nth iteration of the fibonnaci sequence 
								//a string for the input source, and a string for the output destination \
			System.out.println("Correct format: java Prototype <integer> <delimiter> <output_destination>");
			return; 
		
		}
		*/ 
	/*
		if (args.length < 2 || args.length > 3) { //args length should either be 2 (inputsource and output dest) or 3 (plus delimiter)
			System.out.print("Correct format: java Prototype <input_source> <output_dest> <delimiter> (optional)");
			return; 
			
		}
		
		String source = args[0];
		String dest = args[1];
		String delimiter = (args.length == 3) ? args[2] : null; 
		
		Prototype ptype = new Prototype(); 
		*/
		/*
		
		try {
			int iteration = Integer.parseInt(args[0]); //the iteration of the sequence of which all even ints will be added 
			String delimiter = args[1]; //the delimiter the user will use to separate the numbers of the sequence 
			String outputDest = args[2]; //the destination of the output 
			
			Prototype ptype = new Prototype(); 
			ptype.processInputData(iteration, delimiter, outputDest);
		} catch (NumberFormatException e) {
			System.out.print("Error: first argument must be an integer"); 
		}
		*/ 
	}


