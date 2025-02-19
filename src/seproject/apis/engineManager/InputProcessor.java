package seproject.apis.engineManager;
import seproject.annotations.ConceptualAPI;

@ConceptualAPI
public interface InputProcessor {
	
	void setProcessor(DataProcessor processor);
	void setStorageHandler(StorageHandler handler);

}
