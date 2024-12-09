package com.example.blog.exeption;

public class BlogNotFoundExeption extends RuntimeException{
    public BlogNotFoundExeption(String message){
        super(message);
    }
}
