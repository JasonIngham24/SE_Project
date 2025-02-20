package seproject;

import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface InputProcessor {
	
	void setProcessor(DataProcessor processor);
	void setStorageHandler(StorageHandler handler);

}
