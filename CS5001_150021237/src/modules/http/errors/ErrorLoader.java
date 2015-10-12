package modules.http.errors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Simple class to create and load error messages based on error codes.
 * @author 150021237
 *
 */
public class ErrorLoader {

	private static final String PATH = "modules/http/errors/";
	
	private ErrorLoader(){}
	
	/**
	 * Loads the correct error html code.
	 * @param errorCode
	 * @return
	 * @throws IOException
	 */
	public static String getErrorMessage(int errorCode) throws IOException {
		InputStream inp = ClassLoader.getSystemClassLoader().getResourceAsStream(PATH + errorCode + ".html");
		BufferedReader rd = new BufferedReader(new InputStreamReader(inp));
		StringBuilder sb = new StringBuilder();
		String s;
		try {
		        while (null != (s = rd.readLine())) {
		            sb.append(s);
		        }
		} finally {
		        rd.close();
		}
		return sb.toString();
	}
}
