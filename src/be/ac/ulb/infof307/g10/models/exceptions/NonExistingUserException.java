package be.ac.ulb.infof307.g10.models.exceptions;

public class NonExistingUserException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NonExistingUserException() {
		super();
	}

	public NonExistingUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistingUserException(String message) {
		super(message);
	}

	public NonExistingUserException(Throwable cause) {
		super(cause);
	}

}
