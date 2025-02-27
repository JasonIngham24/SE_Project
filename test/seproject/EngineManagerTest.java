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
		EngineManagerAPI enginemanager = new EngineManagerImpl(9);
		int result = enginemanager.sumOfNthEvenFibbonaciNums(9);
		System.out.println("Engine Manager: Collected Data From UserComputeEngine.");
		//user inputs 9 and gets 2+8+34
		Assertions.assertEquals(result, 44);
		//throw new RuntimeException();
	}	
}

