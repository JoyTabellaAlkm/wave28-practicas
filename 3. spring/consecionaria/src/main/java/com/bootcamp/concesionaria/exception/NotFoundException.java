package com.bootcamp.concesionaria.exception;

public class NotFoundException extends Exception{
    public NotFoundException(String entity) {
        super(entity + "Not found");
    }
}
