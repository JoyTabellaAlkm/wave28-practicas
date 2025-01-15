package com.mercadolibre.showroom.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionDTO {
    private String message;
    private String details;

    public ExceptionDTO(String message) {
        this.message = message;
    }

}