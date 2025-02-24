package seproject;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import seproject.apis.enginemanager.EngineManagerAPI;
import seproject.apis.usernetworkbridge.UserComputeEngineAPI;
import seproject.apis.datastorage.DataStorageAPI;
import seproject.apis.enginemanager.EngineManagerImpl;

public class EngineManagerTest {

	@Mock
	private EngineManagerAPI  mockEngineManager;

	private UserComputeEngineAPI mockUserComputeEngineAPI;

	private DataStorageAPI mockDataStorageAPI;

	@Before
	public void setup() {



		mockUserComputeEngineAPI = mock(UserComputeEngineAPI.class);

		mockDataStorageAPI = mock(DataStorageAPI.class);

		//mockSourceHandler = mock(SourceHandler.class);

		//mockStorageHandler = mock(StorageHandler.class);

	}

	@Test
	public void sumOfNthEvenFibbonaciTest() {
		EngineManagerAPI enginemanager = new EngineManagerImpl();
		int result = enginemanager.sumOfNthEvenFibbonaciNums(9);
		System.out.println("Engine Manager: Collected Data From UserComputeEngine.");
		//user inputs 9 and gets 2+8+34
		Assertions.assertEquals(result, 44);
		//throw new RuntimeException();
	}	
}
	//	}
	//	public void sendResultToDataStorage(int result) {
	//		System.out.println("Engine Manager: Sending computed data to DataStorage.");
	//		mockDataStorageAPI.readData(result);		//TODO need method to cast to string or "readData" needs to take in an int
	//	}
	//	public void forwardFinalDestination() {
	//		System.out.println("Engine Manager: Forwarding final destination to DataStorage.");
	//		String dest = storeLocation.getDest();
	//		sendDestToDataStorage(dest);
	//	}
	//	public void sendDestToDataStorage(String dest) {
	//		mockDataStorageAPI.readData(dest);
	//	}
	//	public void setN(SourceHandler userInput) {		//TODO change source to pull from the object SourceHandler
	//		int n = userInput.getSource();				//TODO Implement get methods for SourceHandler
	//	}
	//	public void setDelim(SourceHandler userInput) {
	//		String dLim = userInput.getDLim();
	//	}
	//
	//	@Override
	//	public void setN(int n) {
	//		// TODO Auto-generated method stub
	//		
	//	}
	//
	//	@Override
	//	public void setDelimiter(String dLim) {
	//		// TODO Auto-generated method stub
	//		
	//	}
	//
	//	@Override
	//	public void setStorageLocation(String sL) {
	//		// TODO Auto-generated method stub
	//		
	//	}
	//
	//	@Override
	//	public int sumOfNthEvenFibbonaciNums(int n) {
	//		// TODO Auto-generated method stub
	//		return 0;
	//	}
	//}
