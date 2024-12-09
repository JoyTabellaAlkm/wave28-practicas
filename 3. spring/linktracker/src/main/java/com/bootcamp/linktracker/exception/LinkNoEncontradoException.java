package com.bootcamp.linktracker.exception;

public class LinkNoEncontradoException extends RuntimeException {
    public LinkNoEncontradoException() {
        super("El link no se ha podido encontrar");
    }
}
