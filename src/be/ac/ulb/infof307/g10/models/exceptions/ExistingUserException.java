package be.ac.ulb.infof307.g10.models.exceptions;

public class ExistingUserException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExistingUserException() {
		super();
	}

	public ExistingUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ExistingUserException(String message) {
		super(message);
	}

	public ExistingUserException(Throwable cause) {
		super(cause);
	}

}
