package com.mercadoLibre.blog.exception.customizedExceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
