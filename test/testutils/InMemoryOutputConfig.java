package testutils;
import java.util.ArrayList;
import java.util.List;

public class InMemoryOutputConfig {
    private final List<String> outputData = new ArrayList<>();

    public void writeOutput(String data) {
        outputData.add(data);
    }

    public List<String> getOutputData() {
        return outputData;
    }
}