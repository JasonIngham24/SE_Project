package seproject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoInteractions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import implementations.FileBasedDataStorageImpl;
import seproject.apis.usernetworkbridge.UserComputeEngineAPI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class DataStorageTest {
    private FileBasedDataStorageImpl dataStorageAPI;

    @Mock
    private UserComputeEngineAPI mockComputeEngineAPI; // Mocked dependency

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dataStorageAPI = new FileBasedDataStorageImpl();
    }

    // Validates input handling
    @Test
    void testReadDataHandlesNullSource() {
        String result = dataStorageAPI.readData(null);
        assertEquals("Error: Source file path cannot be null or empty.", result);
    }

    // Exception Handling Transformation
    @Test
    void testWriteDataHandlesIOException() throws IOException {
        // Create a file and make it read-only to simulate write failure
        Path tempFile = Files.createTempFile("testFile", ".txt");
        tempFile.toFile().setReadOnly(); // Makes file non-writable

        boolean result = dataStorageAPI.writeData(tempFile.toString(), "test data");

        assertFalse(result, "Expected writeData() to return false when an IOException occurs.");

        // Cleanup: Ensure file is writable again for deletion
        tempFile.toFile().setWritable(true);
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testReadDataReturnsErrorString() {
        String result = dataStorageAPI.readData("test-source");
        assertEquals("Error: Source file does not exist or is not readable.", result, "Expected readData() to return an error string.");
    }

    @Test
    void testWriteDataReturnsTrue() {
        boolean result = dataStorageAPI.writeData("test-destination", "some data");
        assertTrue(result, "Expected writeData() to return true.");
    }

    @Test
    void testNoUnexpectedDependencyCalls() {
        verifyNoInteractions(mockComputeEngineAPI);
    }
}
