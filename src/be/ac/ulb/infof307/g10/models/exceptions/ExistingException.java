package be.ac.ulb.infof307.g10.models.exceptions;

/**
 * Exception raised when an object already exists
 */
public class ExistingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExistingException() {
		super();
	}

	public ExistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExistingException(String message) {
		super(message);
	}

	public ExistingException(Throwable cause) {
		super(cause);
	}

}
