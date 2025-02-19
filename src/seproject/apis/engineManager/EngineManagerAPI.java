package seproject.apis.engineManager;
import project.annotations.ConceptualAPI;

@ConceptualAPI
public interface EngineManagerAPI {
	
	void setData(int n);
	int getData();
	int sumOfNthEvenFibbonaciNums(int n);

}
