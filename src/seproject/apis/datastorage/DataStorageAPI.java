// Main Interface for the Data Storage API
package seproject.apis.datastorage;

import annotations.ProcessAPI;

public interface DataStorageAPI {

	/**
	 * Reads data from a specified source.
	 *
	 * @param source The source identifier (e.g., file path, database ID).
	 * @return The retrieved data.
	 */
	@ProcessAPI
	String readData(String source);

	/**
	 * Writes data to a specified destination.
	 *
	 * @param destination The destination identifier.
	 * @param data        The data to be written.
	 * @return True if the operation was successful, false otherwise.
	 */
	@ProcessAPI
	boolean writeData(String destination, String data);
}