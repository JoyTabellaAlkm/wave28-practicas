package com.bootcamp.ejercicioblog.exception;

public class EntradaBlogNoExisteException extends RuntimeException {
    public EntradaBlogNoExisteException(String message) {
        super(message);
    }
}
