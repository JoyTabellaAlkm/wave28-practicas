package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DuplicatedBlogException.class)
    public ResponseEntity<?> duplicatedBlog(DuplicatedBlogException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
