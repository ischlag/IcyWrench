package wwwroot.test;

import java.io.IOException;

import Parser.Http.Page;
import logmanager.Logger;
import modules.http.HttpRequestHandler.HttpRequest;

public class Dynamic extends Page {

	@Override
	public void load(HttpRequest httpRequest) throws IOException {
		Logger.getInstance().info(httpRequest.socket.getInetAddress().toString(), 1, "Executing Dynamic");
		String query = httpRequest.uriParser.getURI().getQuery();
		
		StringBuilder c = new StringBuilder();
		c.append("<!DOCTYPE html>");
		c.append("<html>");
		c.append("<body>");
			c.append("<h1> Dynamic: </h1>");
			c.append("<p>");
				
				c.append("GET query: " + (query == null?"":query) + "<br><br>");
				
				c.append("Hello " + System.getProperty("user.name") + "<br><br>");
				c.append("You are running " + System.getProperty("os.name") + " " + System.getProperty("os.version") + "<br>");
			
			c.append("</p>");
		c.append("</body>");
		c.append("</html>");
		
		
		respond(httpRequest, c.toString());
	}

}
