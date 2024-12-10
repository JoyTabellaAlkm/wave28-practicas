package com.bootcamp.youtuber.exception;

public class BlogNoExistenteException extends RuntimeException {
    public BlogNoExistenteException(Long id) {
        super("El blog con id: " + id + " no existe");
    }
}
