package com.bootcamp.tester.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super(String.format("El TestCase con id: %d no existe", id));
    }
}
