package com.bootcamp.vehiculos.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(Long id) {
        super(String.format("Vehiculo con id: %d no encontrado", id));
    }
}
