package org.example.ejercicio_practico_opcional.exception;

  public class PrendaNotFoundException extends RuntimeException {
    public PrendaNotFoundException(Long codigo) {
      super("No se encontró la prenda con código: " + codigo);
    }
}
