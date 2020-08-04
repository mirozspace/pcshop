package shop.error;

@SuppressWarnings("serial")
public abstract class CustomBaseException extends RuntimeException{
    public CustomBaseException(String message) {
        super(message);
    }
}
