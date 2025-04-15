package implementations;

import io.grpc.stub.StreamObserver;
import seproject.grpc.datastorage.DataStorageProto.*;
import seproject.grpc.datastorage.DataStorageServiceGrpc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * gRPC Server-side implementation of the DataStorageService.
 * Provides functionality to read and write data via file I/O.
 */
public class DataStorageAPIImpl extends DataStorageServiceGrpc.DataStorageServiceImplBase {

    /**
     * Handles the gRPC call for reading file content.
     *
     * @param request           The gRPC ReadRequest containing the file path.
     * @param responseObserver  StreamObserver used to return the ReadResponse.
     */
    @Override
    public void readData(ReadRequest request, StreamObserver<ReadResponse> responseObserver) {
        String source = request.getSource();
        ReadResponse.Builder response = ReadResponse.newBuilder();

        // Validate the source path
        if (source == null || source.trim().isEmpty()) {
            response.setError("Source path cannot be empty.");
        } else {
            Path path = Path.of(source);

            // Check if file exists and is readable
            if (!Files.exists(path) || !Files.isReadable(path)) {
                response.setError("File does not exist or is not readable.");
            } else {
                try {
                    // Read content from file
                    response.setContent(Files.readString(path));
                } catch (IOException e) {
                    response.setError("I/O error: " + e.getMessage());
                }
            }
        }

        // Send response and complete the stream
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    /**
     * Handles the gRPC call for writing data to a file.
     *
     * @param request           The gRPC WriteRequest with destination path and data.
     * @param responseObserver  StreamObserver used to return the WriteResponse.
     */
    @Override
    public void writeData(WriteRequest request, StreamObserver<WriteResponse> responseObserver) {
        String destination = request.getDestination();
        String data = request.getData();
        WriteResponse.Builder response = WriteResponse.newBuilder();

        // Validate inputs
        if (destination == null || destination.trim().isEmpty() || data == null) {
            response.setSuccess(false).setError("Invalid input: destination and data cannot be null or empty.");
        } else {
            Path path = Path.of(destination);
            try {
                // Write data to the file
                Files.writeString(path, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                response.setSuccess(true); // Indicate success
            } catch (IOException e) {
                response.setSuccess(false).setError("I/O error: " + e.getMessage());
            }
        }

        // Send response and complete the stream
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
