package implementations;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import seproject.apis.enginemanager.ComputeEngineCoordinator;
import seproject.apis.usernetworkbridge.handlers.SourceHandlerImpl;
import seproject.apis.usernetworkbridge.handlers.StorageHandlerImpl;

public class ComputeServer {
	
	public static void main(String [] args) throws Exception {
		//initialize the actual compute engine components 
		var engineManager = new EngineManagerImpl(0); 
		var sourceHandler = new SourceHandlerImpl(); 
		var storageHandler = new StorageHandlerImpl(); 
		var computeEngine = new UserComputeEngineImpl(sourceHandler, storageHandler); 
		var dataStorage = new FileBasedDataStorageImpl(); 
		var coordinator = new ComputeEngineCoordinator(dataStorage, computeEngine, engineManager); 
		
		
		//create and configure the gRPC server 
		Server server = ServerBuilder.forPort(9090).addService(new ComputeServiceImpl(coordinator)).build(); 
	
		//Start the server and block until it shuts down
		server.start();
		System.out.println("gRPC server is running on port 9090...");
		server.awaitTermination();
	}
	
	

}
