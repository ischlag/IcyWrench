package wwwroot.test;

import java.io.IOException;

import Parser.Http.Page;
import logmanager.Logger;
import modules.http.HttpRequestHandler.HttpRequest;

/**
 * Simple dynamic website which echoes the content from a http request.
 * @author 150021237
 *
 */
public class Echo extends Page {

	@Override
	public void load(HttpRequest httpRequest) throws IOException {
		Logger.getInstance().info(httpRequest.socket.getInetAddress().toString(), 1, "Executing Echo");
		String echo = httpRequest.content;
		echo = "Echo from request content is on the next line.\n<br>".concat(echo);
		
		respond(httpRequest, echo);
	}


}
