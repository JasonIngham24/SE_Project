package seproject.infrastructure;
import seproject.apis.datastorage.DataStorageAPI;

public class InMemoryDataStorageAPI implements DataStorageAPI {

    private final InMemoryInputConfig inputConfig;
    private final InMemoryOutputConfig outputConfig;

    public InMemoryDataStorageAPI(InMemoryInputConfig inputConfig, InMemoryOutputConfig outputConfig) {
        this.inputConfig = inputConfig;
        this.outputConfig = outputConfig;
    }

    @Override
    public String readData(String source) {
        // Simulates reading by returning a concatenated string of input integers
        return inputConfig.getInputData().toString();
    }

    @Override
    public boolean writeData(String destination, String data) {
        // Simulates writing by appending data to outputConfig
        outputConfig.writeOutput(data);
        return true;
    }
}