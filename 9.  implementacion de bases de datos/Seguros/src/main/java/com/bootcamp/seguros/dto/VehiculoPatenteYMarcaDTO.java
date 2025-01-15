package com.bootcamp.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VehiculoPatenteYMarcaDTO {
    private String patente;

    private String marca;
}
