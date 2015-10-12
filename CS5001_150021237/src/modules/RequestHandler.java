package modules;

import java.net.Socket;

import exceptions.IllegalConfigurationException;
import logmanager.Logger;
import modules.http.HttpRequestHandler;

/**
 * Defines which kind of request handler should be applied.
 * @author 150021237
 *
 */
public class RequestHandler {

	/**
	 * Available TCP based protocols.
	 * @author 150021237
	 *
	 */
	public static enum HandlerType {
		HTTP
	};

	private static Logger logger = Logger.getInstance();

	private RequestHandler() {}

	/**
	 * Hook point for different tcp based protocol implementations.
	 * @param handlerType module for tcp based protocols.
	 * @param socket
	 */
	public static void use(HandlerType handlerType, Socket socket) {
		logger.trace("enter RequestHandler.use()");
		switch (handlerType) {
		case HTTP:
			HttpRequestHandler.request(socket);
			break;
		default:
			logger.fatal(null, "No valid handler specified", new IllegalConfigurationException("No valid handler specified"));
		}
	}
}
