package com.mercadolibre.linktracker.exceptions;

public class InactiveResourceException extends RuntimeException{

    public InactiveResourceException(){

    }

    public InactiveResourceException(String message){
        super(message);
    }

}
