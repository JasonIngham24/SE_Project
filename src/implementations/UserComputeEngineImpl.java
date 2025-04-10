package implementations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import seproject.apis.usernetworkbridge.handlers.SourceHandler;
import seproject.apis.usernetworkbridge.handlers.SourceHandlerImpl;
import seproject.apis.usernetworkbridge.handlers.StorageHandler;
import seproject.apis.usernetworkbridge.handlers.StorageHandlerImpl;

public class UserComputeEngineImpl {

	private SourceHandlerImpl sourceHandler;
	private StorageHandlerImpl storageHandler;

	public UserComputeEngineImpl(SourceHandlerImpl sourceHandlerImpl, StorageHandlerImpl storageHandlerImpl) {
		this.sourceHandler = sourceHandlerImpl;
		this.storageHandler = storageHandlerImpl;
	}

	public SourceHandlerImpl sendInputSource(String source, char delimiter) {
		System.out.print("sendInputSource called with source: " + source + "and delimiter: " + delimiter);
		return sourceHandler;
	}

	public StorageHandlerImpl sendOutputDest(String dest) {
		System.out.println("sendOutputDest called with dest: " + dest);
		return storageHandler;
	}

	public List<Integer> getInput() {
		List<Integer> numbers = new ArrayList<>();

		List<Integer> results = null;
		try {
			results = sourceHandler.readIntegers();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Integer result : results) {
			try {
				numbers.add(result);
			} catch (NumberFormatException e) {
				System.out.println("Invalid number format: " + results);
			}
		}

		return numbers;
	}

}
