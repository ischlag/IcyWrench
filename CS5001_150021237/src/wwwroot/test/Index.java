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
		
		StringBuilder c = new StringBuilder();
		c.append("<!DOCTYPE html>");
		c.append("<html>");
		c.append("<body>");
			c.append("<h1> This is test\\Index </h1>");
		c.append("</body>");
		c.append("</html>");
		
		respond(httpRequest, c.toString());
	}


}
