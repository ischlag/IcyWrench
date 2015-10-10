package modules;

import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import Parser.HttpParser;
import Parser.UriParser;
import logmanager.Logger;

/**
 * Can process http request.
 * @author 150021237
 *
 */
class HttpRequestHandler {

	private static final String WWW_ROOT = "wwwroot";
	private static final String EXEC_TYPE = "iw";
	private static Logger logger = Logger.getInstance();

	private HttpRequestHandler() { }

	/**
	 * Creates an HttpRequest Object and processes it.
	 * @param s
	 */
	public static void request(Socket s) {
		logger.trace("enter HttpRequestHandler.request()");

		try {
			try {
				Map<String, String> header = HttpParser.getHttpHeader(s.getInputStream());
				String content = HttpParser.getContent(s.getInputStream());
				
				HttpRequest httpRequest = new HttpRequest(header, content, new UriParser(header.get(HttpParser.HTTP_URI_KEY)));
				processRequest(httpRequest);
				
			} catch (Exception e) {
				logger.error(s.getInetAddress().getHostAddress(), "Illegal Header Format", e);
			}
			
			s.close();
			
		} catch (IOException e) {
			logger.error("Socket close exception", e);
		}
	}

	private static void processRequest(HttpRequest httpRequest) throws URISyntaxException {
		//TODO
	}

	private static void processServiceRequest(HttpRequest httpRequest) {
		//TODO
	}
	
	private static void processFileRequest(HttpRequest httpRequest) {
		//TODO
	}
	
	/**
	 * Immutable container class to easier manage HttpRequest information.
	 * @author 150021237
	 *
	 */
	static class HttpRequest {
		public final Map<String, String> headers;
		public final String content;
		public final UriParser uriParser;
		public HttpRequest(Map<String, String> headers, String content, UriParser uriParser) {
			this.headers = headers;
			this.content = content;
			this.uriParser = uriParser;
		}
	}
}