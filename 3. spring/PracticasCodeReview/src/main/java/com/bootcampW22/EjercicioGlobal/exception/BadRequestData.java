package com.bootcampW22.EjercicioGlobal.exception;

public class BadRequestData extends RuntimeException {
  public BadRequestData(String message) {
    super(message);
  }
}
