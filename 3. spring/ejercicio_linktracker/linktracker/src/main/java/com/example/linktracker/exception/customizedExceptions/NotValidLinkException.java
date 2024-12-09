package com.example.linktracker.exception.customizedExceptions;

public class NotValidLinkException extends RuntimeException {
    public NotValidLinkException(String message) {
        super(message);
    }
}
