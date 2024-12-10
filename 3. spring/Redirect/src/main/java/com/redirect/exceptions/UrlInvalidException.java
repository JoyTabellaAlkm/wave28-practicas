package com.redirect.exceptions;

public class UrlInvalidException extends RuntimeException{
    public  UrlInvalidException(String message){
        super(message);
    }
}
