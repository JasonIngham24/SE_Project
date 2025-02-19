package enginemangementapi;

import src.annotations.enginemangementapi.ConceptualAPI;

@ConceptualAPI
public interface EngineManagerAPI {
	
	void setData(int n);
	int getData();
	int sumOfNthEvenFibbonaciNums(int n);

}
