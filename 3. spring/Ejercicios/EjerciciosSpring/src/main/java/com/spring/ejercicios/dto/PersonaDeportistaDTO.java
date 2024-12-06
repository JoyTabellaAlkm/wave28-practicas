package com.spring.ejercicios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDeportistaDTO {
    private String nombrePersona;
    private String apellido;
    private String nombreDeporte;
}
