package com.bootcamp.ejercicioblog.exception;

public class EntradaBlogYaExisteException extends RuntimeException {
  public EntradaBlogYaExisteException(String message) {
    super(message);
  }
}
