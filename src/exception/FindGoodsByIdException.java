package exception;

public class FindGoodsByIdException extends Exception {

    private static final long serialVersionUID = 1L;

    public FindGoodsByIdException() {
        super();
    }

    public FindGoodsByIdException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindGoodsByIdException(String message) {
        super(message);
    }

    public FindGoodsByIdException(Throwable cause) {
        super(cause);
    }

}
