package be.ac.ulb.infof307.g10.models.exceptions;

public class EmptyUsernameException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public EmptyUsernameException() {
        super();
    }

    public EmptyUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyUsernameException(String message) {
        super(message);
    }

    public EmptyUsernameException(Throwable cause) {
        super(cause);
    }

}
