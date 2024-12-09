package com.blog.spring.exceptions;

public class NotFoundEntrada extends RuntimeException {
    public NotFoundEntrada(String message) {
        super(message);
    }
}
