package seproject;

import java.io.File;

import seproject.apis.enginemanager.ComputeEngineCoordinator;
import seproject.exceptions.ComputationException;




public class TestUser {
	
	// TODO 3: change the type of this variable to the name you're using for your
	// @NetworkAPI interface; also update the parameter passed to the constructor
	private final ComputeEngineCoordinator coordinator; //changed object to ComputeEngineCoordinator 

	public TestUser(ComputeEngineCoordinator coordinator) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ',';
		String inputPath =  "C:\\Users\\jclic\\OneDrive\\Documents\\GitHub\\SE_Project\\test\\seproject\\testInputFile.csv";
		
		// TODO 4: Call the appropriate method(s) on the coordinator to get it to 
		// run the compute job specified by inputPath, outputPath, and delimiter
		try {
			coordinator.startComputation(inputPath, outputPath, delimiter);
			System.out.println("Computation done. Output exists? " + new File(outputPath).exists());

		} catch (ComputationException e) {
			// TODO Auto-generated catch block
			System.err.println("Computation failed for: " + outputPath);
			e.printStackTrace();
		} 
	
	
	}

}