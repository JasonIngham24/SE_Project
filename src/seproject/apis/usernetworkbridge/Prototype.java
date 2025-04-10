package seproject.apis.usernetworkbridge;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.Scanner;
import annotations.NetworkAPIPrototype;
import seproject.apis.usernetworkbridge.handlers.SourceHandler;
import seproject.apis.usernetworkbridge.handlers.StorageHandler;

public class Prototype {

	@NetworkAPIPrototype
	public void prototype(UserComputeEngineAPI api) {
		Scanner scanner = new Scanner(System.in);

		// get input source from the user
		System.out.println("Enter Input Source");
		String source = scanner.nextLine();

		// get output destination
		System.out.println("Enter output destination");
		String dest = scanner.nextLine();

		// get delimiter
		System.out.println("Enter delimiter");
		String delimiter = scanner.nextLine();

		/*
		 * System.out.println("Iteration of Sequence: " + num);
		 * System.out.println("Delimiter: " + delimiter);
		 * System.out.println("Output Location: " + dest);
		 */

		// default delimiter if user chooses not to specify
		if (delimiter == null || delimiter.isEmpty()) {
			delimiter = ",";
		}

		if (isLocalFile(source)) {
			System.out.println("Local file detected");
		} else if (isNetworkLocation(source)) {
			System.out.println("Network location detected");
		} else {
			System.out.print("Unknown source type");
		}

		SourceHandler sourceHandler = api.sendInputSource(source, delimiter);
		StorageHandler storageHanlder = api.sendOutputDest(dest);

	}

	// method to check validity of specified network location
	// throws exception if URL is invalid

	public boolean isNetworkLocation(String source) {
		try {
			new URL(source);
			return true;
		} catch (MalformedURLException e) {
			return false;
		}
	}

	// method to confirm if input source is local file
	public boolean isLocalFile(String source) {
		return Files.exists(Paths.get(source)); // does file exist locally?
	}

	/*
	 * @Override public boolean isValidSource(String source) { // TODO
	 * Auto-generated method stub return false; }
	 */

}
