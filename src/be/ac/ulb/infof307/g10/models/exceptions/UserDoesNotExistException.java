package be.ac.ulb.infof307.g10.models.exceptions;

public class UserDoesNotExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserDoesNotExistException() {
		super();
	}

	public UserDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDoesNotExistException(String message) {
		super(message);
	}

	public UserDoesNotExistException(Throwable cause) {
		super(cause);
	}

}
