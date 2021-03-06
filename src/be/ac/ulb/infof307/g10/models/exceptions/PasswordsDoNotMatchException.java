package be.ac.ulb.infof307.g10.models.exceptions;

/**
 * Exception raised when the password and the confirmation password do not match
 */
public class PasswordsDoNotMatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PasswordsDoNotMatchException() {
		super();
	}

	public PasswordsDoNotMatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordsDoNotMatchException(String message) {
		super(message);
	}

	public PasswordsDoNotMatchException(Throwable cause) {
		super(cause);
	}

}
