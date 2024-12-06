package com.mercadolibre.covid19.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

}
