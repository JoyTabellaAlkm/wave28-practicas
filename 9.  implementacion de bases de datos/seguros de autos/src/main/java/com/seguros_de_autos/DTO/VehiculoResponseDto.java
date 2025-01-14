package com.seguros_de_autos.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoResponseDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anoDeFabricacion;
    private int cantidadDeRuedas;
}
