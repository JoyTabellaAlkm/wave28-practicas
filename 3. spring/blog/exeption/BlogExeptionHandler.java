package com.example.blog.exeption;


import org.springframework.web.bind.annotation.ExceptionHandler;

public class BlogExeptionHandler {
    @ExceptionHandler
    public String blogExeptionHandler(BlogNotFoundExeption exeption){
        return exeption.getMessage();
    }
}
