package seproject.infrastructure;

import org.mockito.Mock;

public class EngineManagerTest implements EngineManagerAPI {
    
	@Mock
	private EngineManagerAPI  mockEngineManager;
	
	private UserComputeEngineAPI mockUserComputeEngineAPI;
	
	private DataStorageAPI mockDataStorageAPI;
	 
	private SourceHandler mockSourceHandler; 
	
	private StorageHandler mockStorageHandler;
	
	@Before
	public void setup() {
		
		mockEngineManager = mock(EngineManagerAPI.class);
		
		mockUserComputeEngineAPI = mock(UserComputeEngineAPI.class);
		
		mockDataStorageAPI = mock(DataStorageAPI.class);
		
		mockSourceHandler = mock(SourceHandler.class);
		
		mockStorageHandler = mock(StorageHandler.class);
		
	}
	
	@Test
	public void sumOfNthEvenFibbonaci(int 9) {
		System.out.println("Engine Manager: Collected Data From UserComputeEngine.");
		//user inputs 9 and gets 2+8+34 
		int result = 44;
		sendResultToDataStorage(result);
	}
	public void sendResultToDataStorage(int result) {
		System.out.println("Engine Manager: Sending computed data to DataStorage.");
		mockDataStorageAPI.readData(result);		//TODO need method to cast to string or "readData" needs to take in an int
	}
	public void forwardFinalDestination(StorageHandler storeLocation) {
		System.out.println("Engine Manager: Forwarding final destination to DataStorage.");
		String dest = storeLocation.getDest();
		sendDestToDataStorage(String dest);
	}
	public void sendDestToDataStorage(String dest) {
		mockDataStorageAPI.readData(result);
	}
	public void setN(SourceHandler userInput) {		//TODO change source to pull from the object SourceHandler
		int n = userInput.getSource();				//TODO Implement get methods for SourceHandler
	}
	public void setDelim(SourceHandler userInput) {
		String dLim = userInput.getDLim();
	}
}
