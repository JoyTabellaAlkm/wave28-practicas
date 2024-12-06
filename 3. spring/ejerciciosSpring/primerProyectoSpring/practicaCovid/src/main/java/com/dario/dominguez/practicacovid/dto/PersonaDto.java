package com.dario.dominguez.practicacovid.dto;

import lombok.Data;

@Data
public class PersonaDto {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
}
