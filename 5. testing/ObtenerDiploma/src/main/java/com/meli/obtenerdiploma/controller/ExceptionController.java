package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController  {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException exception) {
        ExceptionDto exceptionDto = new ExceptionDto(exception.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
