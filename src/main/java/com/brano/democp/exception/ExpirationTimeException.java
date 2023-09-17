package com.brano.democp.exception;

public class ExpirationTimeException extends Exception{

    public ExpirationTimeException() {
        super();
    }

    public ExpirationTimeException(String message) {
        super(message);
    }

    public ExpirationTimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpirationTimeException(Throwable cause) {
        super(cause);
    }

}
