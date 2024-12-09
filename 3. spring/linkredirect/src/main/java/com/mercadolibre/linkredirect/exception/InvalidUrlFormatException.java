package com.mercadolibre.linkredirect.exception;

import org.springframework.web.util.InvalidUrlException;

public class InvalidUrlFormatException extends RuntimeException{
    public InvalidUrlFormatException(String message) {
        super(message);
    }
}
