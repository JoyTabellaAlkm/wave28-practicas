package com.melibootcamp.covid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDeRiesgoDTO {
    private String nombre;
    private String apellido;
}
