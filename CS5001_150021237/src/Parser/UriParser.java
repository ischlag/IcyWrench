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

	private URI innerURI;

	public UriParser(String str) throws URISyntaxException {
		innerURI = new URI(removeHttpVersion(str));
	}

	/**
	 * return inner URI element.
	 * 
	 * @return
	 */
	public URI getURI() {
		return innerURI;
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
}