package seproject.apis.enginemanager;

public class ComputationConfig {
	
	private final String inputPath;
	private final String outputPath; 
	private final char delimiter; 
	
	
	public ComputationConfig(String inputPath, String outputPath, char delimiter) {
		this.inputPath = inputPath; 
		this.outputPath = outputPath; 
		this.delimiter = delimiter; 
	}
	
	
	public String getInputPath() {
		return inputPath; 
	}
	
	public String getOutputPath() {
		return outputPath;
	}
	
	
	public char getDelimiter() {
		return delimiter; 
	}
	
	public String toString(){ 
		return "ComputationConfig{" + 
				"inputPath " + inputPath + '\'' + 
				", outputPath= " + outputPath + '\'' +
				", delimiter= " + delimiter + '}'; 
	}

}
