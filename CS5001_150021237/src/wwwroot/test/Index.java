package wwwroot.test;

import java.io.IOException;

import Parser.Http.Page;
import logmanager.Logger;
import modules.http.HttpRequestHandler.HttpRequest;

/**
 * Dynamic site for the default site in the test folder (like index.html on apache).
 * @author 150021237
 *
 */
public class Index extends Page {

	@Override
	public void load(HttpRequest httpRequest) throws IOException {
		Logger.getInstance().info(httpRequest.socket.getInetAddress().toString(), 1, "Executing test.Index");
		respond(httpRequest, "This is test/Index");
	}


}
