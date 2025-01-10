package com.mercadolibre.jewelry.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDto {
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
}
