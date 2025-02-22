package seproject.apis.enginemanager;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface EngineManagerAPI {
	
	StorageHandler storageHandler;
	SourceHandler sourceHandler;
	
	void setN(int n);								//set methods take the passed through "Handlers"
	void setDelimiter(String dLim);
	void setStorageLocation(String sL);
	
	
	int sumOfNthEvenFibbonaciNums(int n);				//computes & returns value -- might become an object in the future
	

}
