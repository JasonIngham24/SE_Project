package seproject.apis.enginemanager;

import annotations.ConceptualAPI;

@ConceptualAPI
public interface DataProcessor {

	void process(String source, String delimiter, String destination);
}
