package com.example.Blog.exceptions;

public class IdRepeatException extends RuntimeException {
  public IdRepeatException(String message) {
    super(message);
  }
}
