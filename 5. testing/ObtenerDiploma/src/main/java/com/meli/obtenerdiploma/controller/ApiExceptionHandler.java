package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> validation(MethodArgumentNotValidException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
}
