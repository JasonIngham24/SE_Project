package se_project;
import java.io.IOException;
import java.io.InputStream;

@ConceptualAPI
public interface StorageHandler {
	boolean isValidSource(String source);
    InputStream readData(String source) throws IOException;
    void writeData(String destination, String data) throws IOException;
}


