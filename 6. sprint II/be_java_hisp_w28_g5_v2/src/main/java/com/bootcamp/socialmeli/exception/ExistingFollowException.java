package com.bootcamp.socialmeli.exception;


public class ExistingFollowException extends RuntimeException{
    public ExistingFollowException(String message){
        super(message);
    }
}
