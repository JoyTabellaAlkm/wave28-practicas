package com.bootcamp.ejercicio_links.exception;

public class BadPasswordException extends RuntimeException{

    public BadPasswordException(){}

    public BadPasswordException(String message){super(message);}
}
