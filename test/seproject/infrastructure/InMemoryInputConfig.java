package seproject.infrastructure;

public class InMemoryInputConfig {
    private final int inputData;

    public InMemoryInputConfig(int inputData) {
        this.inputData = inputData;
    }

    public int getInputData() {
        return inputData;
    }
}