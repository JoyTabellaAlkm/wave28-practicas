package com.mercadolibre.Blog.exception;

public class BlogNotFoundException extends RuntimeException{

    public BlogNotFoundException() {
    }

    public BlogNotFoundException(String message) {
        super(message);
    }
}
