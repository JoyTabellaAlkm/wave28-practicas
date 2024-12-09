package com.mercadolibre.Blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionBlogHandler {

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<String> BlogNotFoundException( Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(BlogDuplicateException.class)
    public ResponseEntity<String> BlogDuplicateException( Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
