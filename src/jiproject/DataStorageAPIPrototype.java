// Prototype Class for the Data Storage API
package jiproject;
import project.annotations.ProcessAPIPrototype;

public abstract class DataStorageAPIPrototype implements DataStorageAPI {

    /**
     * Prototype method for reading data.
     *
     * @param source The source identifier.
     * @return The retrieved data.
     */
    @ProcessAPIPrototype
    public abstract String readData(String source);

    /**
     * Prototype method for writing data.
     *
     * @param destination The destination identifier.
     * @param data The data to be written.
     * @return True if the operation was successful, false otherwise.
     */
    @ProcessAPIPrototype
    public abstract boolean writeData(String destination, String data);
}
