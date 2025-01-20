package com.mercadolibre.showroom.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String model, Long id) {
        super(String.format("%s con id: %d no encontrado", model, id));
    }
}
