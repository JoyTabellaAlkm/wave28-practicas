package com.bootcamp.link_tracker.exception;

public class LinkTrackConflictException extends RuntimeException {
    public LinkTrackConflictException(String message) {
        super(message);
    }

    public LinkTrackConflictException() {
    }
}
