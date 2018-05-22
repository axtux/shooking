package be.ac.ulb.infof307.g10.models.exceptions;

/**
 * Exception raised because of a wrong password
 */
public class IncorrectPasswordException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException() {
		super();
	}

	public IncorrectPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public IncorrectPasswordException(String message) {
		super(message);
	}

	public IncorrectPasswordException(Throwable cause) {
		super(cause);
	}

}
