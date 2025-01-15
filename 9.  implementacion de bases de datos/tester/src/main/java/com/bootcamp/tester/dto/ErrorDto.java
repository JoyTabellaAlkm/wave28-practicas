package com.bootcamp.tester.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorDto {
    private int status;
    private String message;
    public ErrorDto(HttpStatus status, String message) {
        this.status = status.value();
        this.message = message;
    }
}
