package com.example.blog.exception;

public class BlogDuplicatedException extends RuntimeException{

    public BlogDuplicatedException() {
    }

    public BlogDuplicatedException(String message) {
        super(message);
    }


}
