package com.bootcamp.covid19.model;

import lombok.Data;

@Data
public class Persona {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
}
