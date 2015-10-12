package exceptions;

/**
 * For error throwing services which are hosted by this web server.
 * @author 150021237
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 297813532345580907L;

	public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
