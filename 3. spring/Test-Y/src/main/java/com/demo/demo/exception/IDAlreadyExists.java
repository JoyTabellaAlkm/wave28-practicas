package com.demo.demo.exception;

public class IDAlreadyExists extends RuntimeException {
    public IDAlreadyExists(String message) {
        super(message);
    }
}
