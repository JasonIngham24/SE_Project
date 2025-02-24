package seproject.apis.computestore;
import project.annotations.ConceptualAPI;
import project.annotations.ProcessAPI;

@ProcessAPI
public interface StorageHandler {
	boolean isValidDest(String source);
    
}


