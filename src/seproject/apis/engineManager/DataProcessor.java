package seproject.apis.engineManager;
import seproject.annotations.ConceptualAPI;

@ConceptualAPI
public interface DataProcessor {
	
	    void process(String source, String delimiter, String destination);
	}



