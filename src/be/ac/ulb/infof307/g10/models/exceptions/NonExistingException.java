package be.ac.ulb.infof307.g10.models.exceptions;

public class NonExistingException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NonExistingException() {
		super();
	}

	public NonExistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public NonExistingException(String message) {
		super(message);
	}

	public NonExistingException(Throwable cause) {
		super(cause);
	}

}
