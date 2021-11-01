package com.app.instaclonedemo.exception;

public class InvalidResponseBodyException extends Exception {

    public InvalidResponseBodyException() {
        super();
    }

    public InvalidResponseBodyException(String message) {
        super(message);
    }

    public InvalidResponseBodyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidResponseBodyException(Throwable cause) {
        super(cause);
    }
}
