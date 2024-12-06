package com.mercadolibre.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
