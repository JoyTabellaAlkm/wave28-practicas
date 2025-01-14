package com.example.testcase_api.exception;


public class NotFoundException extends RuntimeException{
    public NotFoundException(String Message){
        super(Message);
    }
}
