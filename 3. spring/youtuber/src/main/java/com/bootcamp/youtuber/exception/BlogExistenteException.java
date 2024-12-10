package com.bootcamp.youtuber.exception;

public class BlogExistenteException extends RuntimeException{
    public BlogExistenteException(Long id) {
        super("El blog con id: " + id + " ya existe en el repositorio");
    }
}
