package Parser.Http;

import java.io.IOException;

import modules.http.HttpRequestHandler.HttpRequest;
import modules.http.HttpResponseHandler;

/**
 * Every http page must use this interface so it can be executed.
 * @author 150021237
 *
 */
public abstract class Page {

	/**
	 * Executes the page application.
	 * @param httpRequest
	 * @throws IOException
	 */
	abstract public void load(HttpRequest httpRequest) throws IOException;
	
	/**
	 * Easy method to respond to the clients request.
	 * @param httpRequest
	 * @param output
	 * @throws IOException
	 */
	protected void respond(HttpRequest httpRequest, String output) throws IOException {
		HttpResponseHandler.sendOk(httpRequest, output);
	}
}
