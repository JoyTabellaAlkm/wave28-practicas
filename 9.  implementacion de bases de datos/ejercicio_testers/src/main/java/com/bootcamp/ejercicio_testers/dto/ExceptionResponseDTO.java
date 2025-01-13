package com.bootcamp.ejercicio_testers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponseDTO {
    private String status;
    private String message;
}
