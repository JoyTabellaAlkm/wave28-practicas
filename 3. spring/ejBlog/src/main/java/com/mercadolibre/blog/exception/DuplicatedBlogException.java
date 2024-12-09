package com.mercadolibre.blog.exception;

public class DuplicatedBlogException extends RuntimeException{

    public DuplicatedBlogException(String message) {
        super(message);
    }
}
