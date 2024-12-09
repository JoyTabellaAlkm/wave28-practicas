package com.example.Ejercicio_Blog.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class IdExistenteException extends RuntimeException{

    public IdExistenteException(String message){
        super(message);
    }
    public IdExistenteException(){}

}
