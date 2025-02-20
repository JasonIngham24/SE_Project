package seproject;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface DataProcessor {
	
	    void process(String source, String delimiter, String destination);
	}



