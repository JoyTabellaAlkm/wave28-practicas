package com.seguros_de_autos.DTO;


import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    private int anoDeFabricacion;
    private int cantidadDeRuedas;
}
