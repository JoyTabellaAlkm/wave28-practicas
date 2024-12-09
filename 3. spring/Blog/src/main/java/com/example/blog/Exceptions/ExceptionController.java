package com.example.blog.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ExistsEntry.class)
    public ResponseEntity<?> handleExistsEntry(ExistsEntry existsEntry){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(existsEntry.getMessage());
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<?> handleNotFound(NotFound notFound){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound.getMessage());
    }
}
