package wwwroot.test;

import java.io.IOException;

import Parser.Http.Page;
import logmanager.Logger;
import modules.http.HttpRequestHandler.HttpRequest;

/**
 * Simple dynamic website which throws an error to demonstrate how the web
 * server is able to recover from faulty web sites.
 * 
 * @author 150021237
 *
 */
public class Fail extends Page {

	@Override
	public void load(HttpRequest httpRequest) throws IOException {
		Logger.getInstance().info(httpRequest.socket.getInetAddress().toString(), 1, "Executing Fail");

		// Simulate a bad programmed website
		throw new IllegalArgumentException();

		// respond(httpRequest, "UNREACHABLE");
	}

}
