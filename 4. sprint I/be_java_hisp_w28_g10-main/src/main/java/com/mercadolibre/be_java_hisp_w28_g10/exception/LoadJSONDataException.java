package com.mercadolibre.be_java_hisp_w28_g10.exception;

public class LoadJSONDataException extends RuntimeException{
    public LoadJSONDataException() {
    }

    public LoadJSONDataException(String message) {
        super(message);
    }
}
