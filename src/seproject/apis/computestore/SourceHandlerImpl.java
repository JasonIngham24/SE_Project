package seproject.apis.computestore;

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
	private String delimiter;

	public SourceHandlerImpl(boolean isNetworkLocation, boolean isLocalFile, String sourcePath, String delimiter) {
		this.isNetworkLocation = isNetworkLocation;
		this.isLocalFile = isLocalFile;
		this.sourcePath = sourcePath; 
		this.delimiter = delimiter; 
	}

	/* readIntegers()
	 * function to read in the integers for processing by the compute component
	 * @return an arraylist of integers that are being read into the file
	 * checks the input source for a URL or a file location for processing 
	 */

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
			while((line = reader.readLine()) != null) {
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
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}

}
