import java.lang.NumberFormatException;
public class Prototype implements UserComputeEngineAPI{
	
	public void processInputData(int num, String delimiter, String dest) {
		System.out.println("Iteration of Sequence: " + num);
		System.out.println("Delimiter: " + delimiter); 
		System.out.println("Output Location: " + dest); 
	}
	
	public static void main (String [] args) {
		//getting user input from the command line 
		//issue - implement local file reading 
		
		if (args.length != 3) { //expecting 3 arguments: a(n) (long?) int for the nth iteration of the fibonnaci sequence 
								//a string for the input source, and a string for the output destination \
			System.out.println("Correct format: java Prototype <integer> <delimiter> <output_destination>");
			return; 
			
		}
		
		try {
			int iteration = Integer.parseInt(args[0]); //the iteration of the sequence of which all even ints will be added 
			String delimiter = args[1]; //the delimiter the user will use to separate the numbers of the sequence 
			String outputDest = args[2]; //the destination of the output 
			
			Prototype ptype = new Prototype(); 
			ptype.processInputData(iteration, delimiter, outputDest);
		} catch (NumberFormatException e) {
			System.out.print("Error: first argument must be an integer"); 
		}
	}

}
