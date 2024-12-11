package com.bootcampW22.EjercicioGlobal.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
