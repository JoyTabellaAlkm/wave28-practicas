package com.bootcamp.ejercicioautos.exception;

public class AutoNotFoundException extends RuntimeException {
    private static final String defaultMessage = "El auto solicitado no fue encontrado";

    public AutoNotFoundException(String message) {
        super(message);
    }

    public AutoNotFoundException() {
        super(defaultMessage);
    }
}
