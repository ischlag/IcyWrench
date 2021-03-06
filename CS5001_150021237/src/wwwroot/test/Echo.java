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
		
		StringBuilder c = new StringBuilder();
		c.append("<!DOCTYPE html>");
		c.append("<html>");
		c.append("<body>");
			c.append("<h1> Echo: </h1>");
			c.append("<p>");
				if(echo.trim().equals("")) { 
					c.append("No content found in request :(");
				} else { 
					c.append(echo);
				}
			c.append("</p>");
		c.append("</body>");
		c.append("</html>");
		
		
		respond(httpRequest, c.toString());
	}


}
