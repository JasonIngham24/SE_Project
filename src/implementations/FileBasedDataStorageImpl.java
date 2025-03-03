package implementations;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import seproject.apis.datastorage.DataStorageAPI;

public class FileBasedDataStorageImpl implements DataStorageAPI {

    @Override
    public String readData(String source) {
        Path filePath = Path.of(source);
        if (!Files.exists(filePath)) {
            return ""; // Return empty string if the file does not exist
        }
        try {
            return Files.readString(filePath);
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // Return empty string on error
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