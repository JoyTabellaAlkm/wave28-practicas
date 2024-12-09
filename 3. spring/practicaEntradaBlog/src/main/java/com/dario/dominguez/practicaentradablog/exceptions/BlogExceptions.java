package com.dario.dominguez.practicaentradablog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BlogExceptions {

    @ExceptionHandler(IdRepetidoException.class)
    public ResponseEntity<?> IdRepetidoException (Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public  ResponseEntity<?> NotFoundException (Exception e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
