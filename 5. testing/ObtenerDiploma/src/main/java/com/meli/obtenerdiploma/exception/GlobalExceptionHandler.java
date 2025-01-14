package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e){
        StringBuilder errorMessage = new StringBuilder("Validation failed: ");
        for (FieldError error: e.getBindingResult().getFieldErrors()){
            errorMessage.append(error.getField())
                    .append(" - ")
                    .append(error.getDefaultMessage())
                    .append("; ");
        }
        ExceptionModel exceptionModel = new ExceptionModel(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                errorMessage.toString()
        );

        return ResponseEntity.badRequest().body(exceptionModel);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e){
        ExceptionModel exceptionModel = new ExceptionModel(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                e.getMessage()
        );

        return ResponseEntity.badRequest().body(exceptionModel);
    }

}
