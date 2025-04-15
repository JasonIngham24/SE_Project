package implementations;

import java.util.List;

import io.grpc.stub.StreamObserver;
import seproject.apis.enginemanager.ComputeEngineCoordinator;
import seproject.proto.ComputationRequest;
import seproject.proto.ComputationResponse;
import seproject.proto.ComputeServiceGrpc;

/*
 * Implementation of generated ComputeService class from protobuf
 */


public class ComputeServiceImpl extends ComputeServiceGrpc.ComputeServiceImplBase {

	private final ComputeEngineCoordinator coordinator; 

	//Constructor injects the compute engine coordinator 
	public ComputeServiceImpl(ComputeEngineCoordinator coordinator) {
		this.coordinator = coordinator; 
	}


	//gRPC method that handles computation requests from the client 
	public void startComputation(ComputationRequest request, StreamObserver<ComputationResponse> responseObserver) {
		try {
			//retrieve data from request message 
			List<Integer> numbers = request.getNumbersList(); 
			String outputPath = request.getOutputPath(); 
			String delimiter = request.getDelimiter(); 

			//Call coordinator to compute results from the list 
			List<Integer> results = coordinator.computeResults(numbers); 

			//write results to file using the full computation pipeline 
			String message = ("Computation completed  and results written to: " + outputPath); 

			//Build response object 
			ComputationResponse response = ComputationResponse.newBuilder()
					.setSuccess(true)
					.setMessage(message)
					.addAllResults(results)
					.build();
			
			//Send response back to client 
			responseObserver.onNext(response);
			responseObserver.onCompleted(); 
		} catch (Exception e) {
			//Handle and return any errors to the client 
			ComputationResponse error = ComputationResponse.newBuilder()
					.setSuccess(false)
					.setMessage("Computation failed: " + e.getMessage())
					.build(); 
			responseObserver.onNext(error);
			responseObserver.onCompleted(); 
		}
	}

}
