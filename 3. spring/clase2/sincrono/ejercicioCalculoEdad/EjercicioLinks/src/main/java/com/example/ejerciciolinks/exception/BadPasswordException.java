package com.example.ejerciciolinks.exception;

public class BadPasswordException extends RuntimeException{

    public BadPasswordException (){}

    public BadPasswordException(String message){super(message);}
}
