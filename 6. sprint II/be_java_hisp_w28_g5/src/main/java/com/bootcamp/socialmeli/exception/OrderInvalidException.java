package com.bootcamp.socialmeli.exception;

public class OrderInvalidException extends RuntimeException{
    public OrderInvalidException(String message){
        super(message);
    }
}
