/*
 * 
 * 4. An API between two separate components within the compute engine. One
component will handle initialization, reading, and writing for the job, and a second
component will do the actual computation.
a. As a first step, determine which component is the user for this API, and
make sure your design and prototype reflect that
b. Similarly to 2c, add @ConceptualAPI and @ConceptualAPIPrototype to
the interface and prototype method for this API
*/


//Prototype Class For EngineManagerAPI


package enginemangementapi;
import project.annotations.ConceptualAPIPrototype;
public class EngineManagerAPIPrototype implements EngineManagerAPI {
	
	@Override
	@ConceptualAPIPrototype
	public void setData(int n) {
		// TODO Auto-generated method stubs
		
	}

	@Override
	@ConceptualAPIPrototype
	public int getData() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@ConceptualAPIPrototype
	public int sumOfNthEvenFibbonaciNums(int n) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
