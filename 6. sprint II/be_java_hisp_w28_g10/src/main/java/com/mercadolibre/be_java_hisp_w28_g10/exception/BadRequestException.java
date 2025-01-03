package com.mercadolibre.be_java_hisp_w28_g10.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
