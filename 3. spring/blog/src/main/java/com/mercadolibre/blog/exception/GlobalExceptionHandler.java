package com.mercadolibre.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ExceptionModel(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("America/Bogota")
                )), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> resourceNotFoundException(AlreadyExistsException e) {
        return new ResponseEntity<>(new ExceptionModel(
                e.getMessage(),
                HttpStatus.CONFLICT,
                ZonedDateTime.now(ZoneId.of("America/Bogota")
                )), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalException(Exception e) {
        return new ResponseEntity<>(new ExceptionModel(
                e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now(ZoneId.of("America/Bogota")
                )), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
