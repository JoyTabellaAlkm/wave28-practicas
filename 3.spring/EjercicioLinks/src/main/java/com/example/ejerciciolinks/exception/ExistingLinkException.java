package com.example.ejerciciolinks.exception;

public class ExistingLinkException extends RuntimeException{
    public ExistingLinkException(){}
    public ExistingLinkException(String message){super(message);}
}
