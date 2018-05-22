package be.ac.ulb.infof307.g10.models.exceptions;

/**
 * Exception raised because of an empty password
 */
public class EmptyPasswordException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmptyPasswordException() {
        super();
    }

    public EmptyPasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyPasswordException(String message) {
        super(message);
    }

    public EmptyPasswordException(Throwable cause) {
        super(cause);
    }

}
