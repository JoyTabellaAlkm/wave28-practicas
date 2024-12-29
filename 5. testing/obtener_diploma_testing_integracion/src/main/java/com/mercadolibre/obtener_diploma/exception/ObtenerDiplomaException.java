package com.mercadolibre.obtener_diploma.exception;


import org.springframework.http.HttpStatus;

import com.mercadolibre.obtener_diploma.model.ErrorDTO;

import lombok.Getter;

@Getter
public class ObtenerDiplomaException extends RuntimeException {

    private final ErrorDTO error;
    private final HttpStatus status;

    public ObtenerDiplomaException(String message, HttpStatus status) {
        this.error = new ErrorDTO(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}
