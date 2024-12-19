package com.mercadolibre.be_java_hisp_w28_g10.exception;

public class ConflictException extends RuntimeException{
    public ConflictException(){}
    public ConflictException(String message) {
        super(message);
    }
}
