package com.bootcamp.socialmeli.exception;

public class OrderValidException extends RuntimeException{
    public OrderValidException(String message){
        super(message);
    }
}
