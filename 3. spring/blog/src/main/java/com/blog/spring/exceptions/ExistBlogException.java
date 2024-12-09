package com.blog.spring.exceptions;

public class ExistBlogException extends RuntimeException {
    public ExistBlogException(String message) {
        super(message);
    }
}
