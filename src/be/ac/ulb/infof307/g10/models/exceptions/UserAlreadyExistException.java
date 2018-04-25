package be.ac.ulb.infof307.g10.models.exceptions;

public class UserAlreadyExistException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistException() {
		super();
	}

	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistException(String message) {
		super(message);
	}

	public UserAlreadyExistException(Throwable cause) {
		super(cause);
	}

}
