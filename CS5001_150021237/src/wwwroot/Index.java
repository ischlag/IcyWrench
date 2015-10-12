package wwwroot;

import java.io.IOException;

import Parser.Http.Page;
import logmanager.Logger;
import modules.http.HttpRequestHandler.HttpRequest;

/**
 * Default site for the root of the this web site.
 * @author 150021237
 *
 */
public class Index extends Page {

	@Override
	public void load(HttpRequest httpRequest) throws IOException {
		Logger.getInstance().info(httpRequest.socket.getInetAddress().toString(), 1, "Executing Index");
		respond(httpRequest, "This is Index");
	}


}
