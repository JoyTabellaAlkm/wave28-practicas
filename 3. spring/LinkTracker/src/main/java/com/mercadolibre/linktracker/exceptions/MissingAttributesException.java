package com.mercadolibre.linktracker.exceptions;

public class MissingAttributesException extends RuntimeException{

    public MissingAttributesException(){

    }

    public MissingAttributesException(String message){
        super(message);
    }

}
