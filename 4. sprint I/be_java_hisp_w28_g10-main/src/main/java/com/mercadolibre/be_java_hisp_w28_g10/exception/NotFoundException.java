package com.mercadolibre.be_java_hisp_w28_g10.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
