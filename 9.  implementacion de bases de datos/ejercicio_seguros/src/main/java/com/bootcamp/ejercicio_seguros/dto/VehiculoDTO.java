package com.bootcamp.ejercicio_seguros.dto;

import com.bootcamp.ejercicio_seguros.model.Siniestro;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class VehiculoDTO {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int cantidadRuedas;
}
