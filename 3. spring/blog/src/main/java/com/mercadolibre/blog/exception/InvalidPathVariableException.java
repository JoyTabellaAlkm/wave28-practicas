package com.mercadolibre.blog.exception;

public class InvalidPathVariableException extends RuntimeException{
    public InvalidPathVariableException (String message){
        super(message);
    }
}
