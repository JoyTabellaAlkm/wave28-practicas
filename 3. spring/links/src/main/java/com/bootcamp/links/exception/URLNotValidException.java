package com.bootcamp.links.exception;

public class URLNotValidException extends RuntimeException {

    public URLNotValidException() {

    }

    public URLNotValidException(String message) {
        super(message);
    }
}
