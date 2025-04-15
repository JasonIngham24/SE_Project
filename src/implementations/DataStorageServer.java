package implementations;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import implementations.DataStorageServiceImpl;

public class DataStorageServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new DataStorageServiceImpl())
                .build()
                .start();

        System.out.println("Server started on port 50051");
        server.awaitTermination();
    }
}
