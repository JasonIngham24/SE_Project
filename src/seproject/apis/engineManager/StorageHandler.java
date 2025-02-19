package seproject.apis.engineManager;
import java.io.IOException;
import java.io.InputStream;

import seproject.annotations.ConceptualAPI;

@ConceptualAPI
public interface StorageHandler {
	boolean isValidDest(String source);
    
}


