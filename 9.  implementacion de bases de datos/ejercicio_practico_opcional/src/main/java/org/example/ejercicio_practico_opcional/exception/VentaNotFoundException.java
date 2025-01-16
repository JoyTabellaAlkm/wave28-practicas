package org.example.ejercicio_practico_opcional.exception;

public class VentaNotFoundException extends RuntimeException {
    public VentaNotFoundException(Long numero) {
        super("No se encontró la prenda con código: " + numero);
    }
}
