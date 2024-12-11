package com.bootcamp.linktracker.exception;

public class LinkAlreadyExistsException extends RuntimeException {
    public LinkAlreadyExistsException(String message) {
        super(message);
    }
}
