package seproject.apis.computestore;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class StorageHandlerImpl {
	boolean isValidDest;
	private String destination;

	public StorageHandlerImpl(boolean validDest, String destination) {
		this.isValidDest = validDest;
		this.destination = destination;
	}

	public StorageHandlerImpl() {
		this.isValidDest = true;
		this.destination = " ";
	}

	/*
	 * single threaded function to write results of calculation to destination
	 * 
	 * */
	public void writeResults(List<Integer> results) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
			for (int result : results) {
				writer.write(result + "\n");
			}
		}
	}
	
	/*
	 * multithreaded callable task for writing results to destination
	 * 
	 * */
	public Callable<Boolean> getWriteTask(List<Integer> results){
		return () -> { 
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
				for (int result : results) {
					writer.write(result + "\n");
				}
				return true;  
			} catch (IOException e) {
				System.err.println("Failed to write to file: " + e.getMessage()); 
				return false; 
			}
		};
	}

	public void setDest(String dest) {
		this.destination = dest;
	}

	public void setIsValidDest(boolean bool) {
		this.isValidDest = bool;
	}

}
