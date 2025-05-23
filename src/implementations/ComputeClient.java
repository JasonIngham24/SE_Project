package implementations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import seproject.proto.ComputeServiceGrpc;

import seproject.proto.ComputationRequest;
import seproject.proto.ComputationResponse;


public class ComputeClient {
	
	public static void main(String[] args) {
		try (Scanner scnr = new Scanner(System.in)){
			
			//set up the gRPC channel to the server 
			ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
					.usePlaintext()
					.build();
			
			//create a blocking stub (synchronous client) 
			ComputeServiceGrpc.ComputeServiceBlockingStub stub = ComputeServiceGrpc.newBlockingStub(channel); 
			
			System.out.println("Choose input method: ");
			System.out.println("1. Enter Numbers Manually");
			System.out.println("2. Load numbers from a file"); 
			
			int choice = Integer.parseInt(scnr.nextLine()); 
			List<Integer> numbers = new ArrayList<>(); 
			
			if (choice == 1) {
				System.out.println("Enter numbers separated by commas: ");
				String inputLine = scnr.nextLine();
				numbers = Arrays.stream(inputLine.split(","))
						.map(String::trim)
						.map(Integer::parseInt)
						.collect(Collectors.toList()); 
			} else if (choice == 2) {
				System.out.println("Enter input file path: "); 
				String inputPath = scnr.nextLine(); 
				try {
					numbers = Files.readAllLines(Path.of(inputPath))
							.stream()
							.flatMap(line -> Arrays.stream(line.split(",")))
							.map(String::trim)

							.map(Integer::parseInt)
							.collect(Collectors.toList()); 
				} catch(IOException e) {
					System.out.println("Failed to read file: " + e.getMessage());
					return; 
				}
			} else {
				System.out.println("Invalid Choice"); 
				return; 
			}

			
			System.out.println("Enter output filepath: ");
			String outputPath = scnr.nextLine(); 
			
			System.out.println("Enter delimiter (press Enter for default ','): "); 
			String delimiter = scnr.nextLine();
			if (delimiter.isEmpty()) {
				delimiter = ","; 
			}
			
			ComputationRequest request = ComputationRequest.newBuilder()
					.addAllNumbers(numbers)
					.setOutputPath(outputPath)
					.setDelimiter(delimiter)
					.build();
			
			try {
				ComputationResponse response = stub.startComputation(request); 
				if(response.getSuccess()) {
					System.out.println("Computation Succeeded!");
					System.out.println("Message: " + response.getMessage()); 
					System.out.print("Results: " + response.getResultsList());
				} else {
					System.out.println("Computation Failed: " + response.getMessage()); 
				}
			} catch (Exception e) {
				System.out.print("Error during gRPC call: " + e.getMessage());
				e.printStackTrace();
			}
			
			channel.shutdown(); 

		}
	}

}
