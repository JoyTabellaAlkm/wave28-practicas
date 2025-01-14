package com.example.siniestros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaModeloDto {
    private String patente;
    private String marca;
    private String modelo;
    public PatenteMarcaModeloDto(Object[] obj){
        this.patente = (String)obj[0];
        this.marca = (String) obj[1];
        this.modelo = (String) obj[2];
    }
}
