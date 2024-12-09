package com.mercadolibre.blog.exception;

public class DuplicatedEntryException extends RuntimeException{
    public DuplicatedEntryException(String message){
        super(message);
    }
}
