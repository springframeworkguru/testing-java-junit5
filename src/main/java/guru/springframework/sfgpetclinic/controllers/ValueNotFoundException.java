package guru.springframework.sfgpetclinic.controllers;

public class ValueNotFoundException extends RuntimeException {

    public ValueNotFoundException() {
    }

    public ValueNotFoundException(String message) {
        super(message);
    }

    public ValueNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValueNotFoundException(Throwable cause) {
        super(cause);
    }

    public ValueNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
