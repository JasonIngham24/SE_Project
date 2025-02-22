//package seproject.apis.computestore;
package seproject;
import seproject.apis.enginemanager;
public class EngineManagerImpl implements EngineManagerAPI{
	
	//attributes
	private SourceHandler sourceHandler;	//gets input from sourceHandler ("User")
	
	//constructor
	public EngineManagerImpl(SourceHandler sourceHandler) {
		this.sourceHandler = sourceHandler;
	}