package com.bootcamp.link_tracker.exception;

public class LinkTrackNotValidException extends RuntimeException {
  public LinkTrackNotValidException() {}
  public LinkTrackNotValidException(String message) {
        super(message);
    }
}
