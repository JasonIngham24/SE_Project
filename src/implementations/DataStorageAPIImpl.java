package implementations;

import seproject.apis.datastorage.DataStorageAPI;
import seproject.apis.usernetworkbridge.UserComputeEngineAPI;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataStorageAPIImpl implements DataStorageAPI {

    // Fields for any APIs that this implementation may need to call
    private final UserComputeEngineAPI computeEngineAPI;

    // Constructor initializing dependencies
    public DataStorageAPIImpl(UserComputeEngineAPI computeEngineAPI) {
        if (computeEngineAPI == null) {
            throw new IllegalArgumentException("ComputeEngineAPI cannot be null");
        }
        this.computeEngineAPI = computeEngineAPI;
    }

    @Override
    public String readData(String source) {
        // Validate that source is not null or empty
        if (source == null || source.trim().isEmpty()) {
            throw new IllegalArgumentException("Source file path cannot be null or empty");
        }

        // Validate that the file exists before attempting to read
        Path filePath = Path.of(source);
        if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
            throw new IllegalArgumentException("Source file does not exist or is not readable: " + source);
        }

        // Placeholder implementation returning an empty string
        return "";
    }

    @Override
    public boolean writeData(String destination, String data) {
        // Validate that destination is not null or empty
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination file path cannot be null or empty");
        }

        // Validate that data is not null (empty string is allowed)
        if (data == null) {
            throw new IllegalArgumentException("Data to be written cannot be null");
        }

        // Validate that the destination file is writable (if it exists)
        Path filePath = Path.of(destination);
        if (Files.exists(filePath) && !Files.isWritable(filePath)) {
            throw new IllegalArgumentException("Destination file exists but is not writable: " + destination);
        }

        // Placeholder implementation returning false (failure)
        return false;
    }
}