package com.bootcamp.ejerciciocovid19.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
