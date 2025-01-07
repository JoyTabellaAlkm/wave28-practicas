package com.bootcamp.socialmeli.exception;
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String model, Long id) {
        super(String.format("%s with id: %d not found", model, id));
    }
}
