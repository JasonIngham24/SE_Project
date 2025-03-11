package implementations;

import seproject.apis.datastorage.DataStorageAPI;
import seproject.apis.usernetworkbridge.UserComputeEngineAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class DataStorageAPIImpl implements DataStorageAPI {

    private final UserComputeEngineAPI computeEngineAPI;

    // Constructor validating dependencies
    public DataStorageAPIImpl(UserComputeEngineAPI computeEngineAPI) {
        if (computeEngineAPI == null) {
            throw new IllegalArgumentException("ComputeEngineAPI cannot be null");
        }
        this.computeEngineAPI = computeEngineAPI;
    }

    Override
    public String readData(String source) {
        if (source == null || source.trim().isEmpty()) {
            return "Error: Source file path cannot be null or empty.";
        }

        Path filePath = Path.of(source);
        if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
            return "Error: Source file does not exist or is not readable.";
        }

        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            return "Error: Failed to read file due to an I/O issue.";
        } catch (Exception e) {
            return "Error: An unexpected error occurred while reading the file.";
        }
    }


    @Override
    public boolean writeData(String destination, String data) {
        if (destination == null || destination.trim().isEmpty()) {
            return false;
        }

        if (data == null) {
            return false;
        }

        Path filePath = Path.of(destination);
        if (Files.exists(filePath) && !Files.isWritable(filePath)) {
            return false;
        }

        try {
            Files.writeString(filePath, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}