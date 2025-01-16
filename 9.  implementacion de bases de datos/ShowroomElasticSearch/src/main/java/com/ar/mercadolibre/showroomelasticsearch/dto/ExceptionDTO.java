package com.ar.mercadolibre.showroom.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExceptionDTO {
    private String message;
    private String details;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public ExceptionDTO(String message, String details) {
        this.message = message;
        this.details = details;
    }
}
