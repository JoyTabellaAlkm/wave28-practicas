package com.mercadolibre.lasperlas.controller;

import java.util.NoSuchElementException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler({ NoSuchElementException.class })
    public ResponseEntity<?> handleException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }

}
