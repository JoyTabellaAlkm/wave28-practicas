package com.meli.obtenerdiploma.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionModel {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
}
