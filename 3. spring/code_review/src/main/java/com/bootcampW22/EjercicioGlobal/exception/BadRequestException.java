package com.bootcampW22.EjercicioGlobal.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BadRequestException extends RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }
}
