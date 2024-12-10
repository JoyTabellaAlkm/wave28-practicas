package com.bootcamp.youtuber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class MainExceptionHandler {

    @ExceptionHandler(exception = BlogNoExistenteException.class)
    public ResponseEntity<String> blogNotFound(BlogNoExistenteException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(exception = BlogExistenteException.class)
    public ResponseEntity<String> duplicatedBlog(BlogExistenteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
