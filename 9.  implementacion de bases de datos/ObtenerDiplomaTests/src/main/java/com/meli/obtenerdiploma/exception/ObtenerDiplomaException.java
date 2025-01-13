package com.meli.obtenerdiploma.exception;


import com.meli.obtenerdiploma.model.Error;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ObtenerDiplomaException extends RuntimeException {

    private final Error error;
    private final HttpStatus status;

    public ObtenerDiplomaException(String message, HttpStatus status) {
        this.error = new Error(this.getClass().getSimpleName(), message);
        this.status = status;
    }

}