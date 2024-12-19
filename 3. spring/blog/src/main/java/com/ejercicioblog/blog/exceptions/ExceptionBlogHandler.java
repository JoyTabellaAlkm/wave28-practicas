package com.ejercicioblog.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionBlogHandler {
    @ExceptionHandler(BlogNotFound.class)
    public ResponseEntity<String> BlogNotFound(){
        return ResponseEntity<String>.status(HttpStatus.NOT_FOUND);
    }
}
