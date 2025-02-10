
public class Prototype implements UserComputeEngineAPI{
	
	public void processInputData(String input, String delimiter, String dest) {
		System.out.println("Input Source: " + input);
		System.out.println("Delimiter: " + delimiter); 
		System.out.println("Output Location: " + dest); 
	}
	
	public static void main(String[] args) {
        Prototype engine = new Prototype();

        // Example user input
        String inputSource = "input_data.txt";  // The user specifies the source file
        String delimiter = ",";                 // The user chooses comma as the delimiter
        String outputDestination = "console";   // The user chooses console as the output destination

        // Configure the job with the user's choices
        engine.processInputData(inputSource, delimiter, outputDestination);
    }

}
