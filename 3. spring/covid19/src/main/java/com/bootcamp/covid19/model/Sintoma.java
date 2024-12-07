package com.bootcamp.covid19.model;

import lombok.Data;

@Data
public class Sintoma {
    private Long codigo;
    private String nombre;
    private Integer nivelDeGravedad;
}
