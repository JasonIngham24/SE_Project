package seproject.apis.computestore;
import annotations.ConceptualAPI;
import annotations.ProcessAPI;

@ProcessAPI
public interface StorageHandler {
	boolean isValidDest(String source);
    
}


