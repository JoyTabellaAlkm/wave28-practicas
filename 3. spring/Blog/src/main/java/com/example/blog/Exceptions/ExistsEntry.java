package com.example.blog.Exceptions;

public class ExistsEntry extends RuntimeException {
    public ExistsEntry(String message) {
        super(message);
    }
}
