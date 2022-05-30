package exception;

public class AddGoodsException extends Exception {

    private static final long serialVersionUID = 1L;

    public AddGoodsException() {
        super();
    }

    public AddGoodsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddGoodsException(String message) {
        super(message);
    }

    public AddGoodsException(Throwable cause) {
        super(cause);
    }

}
