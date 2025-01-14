package com.example.api_joyas.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Long id, String type) {
        super("El '" + type + "' con el id '" + id + "' no existe.");

    }
}
