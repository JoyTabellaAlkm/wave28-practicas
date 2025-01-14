package com.mercadolibre.ejerciciohql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ExceptionDTO {

    public ExceptionDTO(String message) {
        this.message = message;
    }

    private String message;

}
