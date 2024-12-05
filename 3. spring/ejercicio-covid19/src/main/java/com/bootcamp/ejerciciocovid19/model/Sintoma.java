package com.bootcamp.ejerciciocovid19.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Sintoma {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;
}
