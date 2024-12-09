package com.bootcamp.linktracker.exception;

public class ServiceErrorException extends RuntimeException {
    public ServiceErrorException(String message) {
        super(message);
    }
}
