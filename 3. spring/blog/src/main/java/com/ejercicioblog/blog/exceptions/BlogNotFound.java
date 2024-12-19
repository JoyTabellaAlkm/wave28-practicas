package com.ejercicioblog.blog.exceptions;

public class BlogNotFound extends RuntimeException{

    public BlogNotFound() {
    }

    public BlogNotFound(String message) {
        super(message);
    }
}
