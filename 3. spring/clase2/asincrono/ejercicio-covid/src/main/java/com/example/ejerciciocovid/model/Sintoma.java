package com.example.ejerciciocovid.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;
}
