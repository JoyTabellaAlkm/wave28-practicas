package com.example.excepciones.exception;

public class AlreadyExistsException extends  RuntimeException{
    public AlreadyExistsException(String message) {
        super(message);
    }
}
