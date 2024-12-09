package com.mercadolibre.blog.exception;

public class DuplicatedIdException extends RuntimeException {
    public DuplicatedIdException(String message) {
        super(message);
    }
}
