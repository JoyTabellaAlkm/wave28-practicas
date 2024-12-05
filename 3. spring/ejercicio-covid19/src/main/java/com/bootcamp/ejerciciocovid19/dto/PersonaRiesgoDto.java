package com.bootcamp.ejerciciocovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class PersonaRiesgoDto {
    private String nombre;
    private String apellido;
    private int edad;

}

