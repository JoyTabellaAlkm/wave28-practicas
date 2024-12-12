package com.bootcamp.blog.exception;

public class IdExistingException extends RuntimeException{

    public IdExistingException(String message){
        super(message);
    }
    public IdExistingException(){}

}
