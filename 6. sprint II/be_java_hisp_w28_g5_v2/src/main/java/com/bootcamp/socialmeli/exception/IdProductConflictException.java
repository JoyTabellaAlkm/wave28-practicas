package com.bootcamp.socialmeli.exception;

public class IdProductConflictException extends RuntimeException{

    public IdProductConflictException(Long id) {
        super(String.format("User already has a post for product ID: %d", id));
    }

}
