package com.bootcamp.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoPatenteMarcaModeloTotalDTO {
    private String patente;
    private String marca;
    private String modelo;
    private double perdidaEconomica;
    private double sumaPerdidaEconomica;

}