package seckill.dormsystem.exception;

public class TokenException extends ServiceException {
    public TokenException() {
        super();
    }
    public TokenException(String message) {
        super(message);
    }
    public TokenException(String message, Throwable cause) {
        super(message, cause);
    }
    public TokenException(Throwable cause) {
        super(cause);
    }
    public TokenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
