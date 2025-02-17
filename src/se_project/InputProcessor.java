package se_project;

@ConceptualAPI
public interface InputProcessor {
	
	void setProcessor(DataProcessor processor);
	void setStorageHandler(StorageHandler handler);

}
