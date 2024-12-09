package com.mercadolibre.blogyoutuber.exceptions;


public class IdAlreadyExistsException extends RuntimeException {

    public IdAlreadyExistsException(){}

    public IdAlreadyExistsException(String message){
        super(message);
    }
}
