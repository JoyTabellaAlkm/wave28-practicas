package com.mercadolibre.Blog.exception;

public class BlogDuplicateException extends RuntimeException{
    public BlogDuplicateException() {
    }

    public BlogDuplicateException(String message) {
        super(message);
    }
}
