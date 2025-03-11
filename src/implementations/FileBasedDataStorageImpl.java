package implementations;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import seproject.apis.datastorage.DataStorageAPI;

public class FileBasedDataStorageImpl implements DataStorageAPI {

    @Override
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
        Path filePath = Path.of(destination);
        try {
            Files.writeString(filePath, data, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Return failure if an error occurs
        }
    }
}