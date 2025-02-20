package seproject;
import java.io.IOException;
import java.io.InputStream;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface StorageHandler {
	boolean isValidDest(String source);
    
}


