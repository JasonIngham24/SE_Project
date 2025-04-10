package seproject.apis.usernetworkbridge.handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SourceHandlerImpl {
	private boolean isNetworkLocation;
	private boolean isLocalFile;
	private String sourcePath;
	private char delimiter;

	public SourceHandlerImpl(boolean isNetworkLocation, boolean isLocalFile, String sourcePath, char delimiter) {
		this.isNetworkLocation = isNetworkLocation;
		this.isLocalFile = isLocalFile;
		this.sourcePath = sourcePath;
		this.delimiter = delimiter;
	}

	/*
	 * readIntegers() function to read in the integers for processing by the compute
	 * component
	 * 
	 * @return an arraylist of integers that are being read into the file checks the
	 * input source for a URL or a file location for processing
	 */

	public SourceHandlerImpl() {
		// TODO Auto-generated constructor stub
		this.isNetworkLocation = true;
		this.isLocalFile = false;
		this.sourcePath = " ";
		this.delimiter = ',';
	}
	/*
	 * Helper Constructor 
	 */
	
	public static SourceHandlerImpl createLocalFileHandler(String path, char delimiter) {
	    SourceHandlerImpl handler = new SourceHandlerImpl();
	    handler.setSource(path);
	    handler.setDelimiter(delimiter);
	    handler.isLocalFile = true;
	    return handler;
	}

	public List<Integer> readIntegers() throws IOException {
		List<Integer> numbers = new ArrayList<>();
		BufferedReader reader = null;

		try {
			if (isNetworkLocation) {
				URL url = new URL(sourcePath);
				reader = new BufferedReader(new InputStreamReader(url.openStream()));
			} else if (isLocalFile) {
				reader = new BufferedReader(new FileReader(sourcePath));
			} else {
				throw new IOException("Unsupported Source Type.");
			}

			String line;
			while ((line = reader.readLine()) != null) {
				numbers.add(Integer.parseInt(line.trim()));
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return numbers;
	}

	public void setSource(String source) {
		this.sourcePath = source;
	}

	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}
	
	public char getDelimiter() {
		return this.delimiter; 
	}

}
