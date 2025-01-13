package com.bootcamp.joyeria.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super("Joya with id: " + id + " not found");
    }
}
