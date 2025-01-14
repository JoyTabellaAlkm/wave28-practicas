package com.example.siniestros.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatenteMarcaDto {
    private String patente;
    private String marca;
    public PatenteMarcaDto(Object[] obj){
        this.patente = (String)obj[0];
        this.marca = (String) obj[1];
    }
}
