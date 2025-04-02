package seproject.apis.usernetworkbridge.handlers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
	
	public void writeResults(List<Integer> results) throws IOException { 
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))){
			for (int result : results) {
				writer.write(result + "\n");
			}
		}
	}
	

}
