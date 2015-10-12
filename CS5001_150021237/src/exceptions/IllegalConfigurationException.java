package exceptions;

/**
 * For invalid and fatal web server configurations.
 * @author 150021237
 *
 */
public class IllegalConfigurationException extends Exception {

	private static final long serialVersionUID = -8958353141430768150L;

    public IllegalConfigurationException(String message) {
        super(message);
    }

    public IllegalConfigurationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
