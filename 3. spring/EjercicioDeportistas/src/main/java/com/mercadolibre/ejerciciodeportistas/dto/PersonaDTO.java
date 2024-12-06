package com.mercadolibre.ejerciciodeportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private String name;
    private String apellido;
    private int edad;
}
