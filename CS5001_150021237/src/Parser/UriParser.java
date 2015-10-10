package Parser;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * class to parse uri request with an HTTP version info a the end.
 * 
 * @author 150021237
 *
 */
public class UriParser {

	private URI innerUri;

	public UriParser(String str) throws URISyntaxException {
		innerUri = new URI(removeHttpVersion(str));
	}

	/**
	 * Return innerUri element.
	 * 
	 * @return
	 */
	public URI getURI() {
		return innerUri;
	}

	private String removeHttpVersion(String str) {
		int last = str.lastIndexOf(' ');
		if (last > 0 && last < str.length()) {
			if (str.substring(last).trim().toUpperCase().equals("HTTP/1.1")
					|| str.substring(last).trim().toUpperCase().equals("HTTP/1.0"))
				return str.substring(0, last);
		}
		return str;
	}
	
	public String getFolderPath(){
		String path = innerUri.getPath();
		int last = path.lastIndexOf('/');
		
		
		return "";
	}
	
	public String getFileName() {
		return "";
	}
	
	public String getFileType() {
		return "";
	}
	
	
}
