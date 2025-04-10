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
							.flatMap(line -> Arrays.stream(line.split(","))).map(String::trim)
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
		}
	}

}
