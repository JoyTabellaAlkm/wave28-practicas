package com.bootcampW22.EjercicioGlobal.exception;

public class BadRequest extends RuntimeException {
    public BadRequest(String message) {
        super(message);
    }
}
