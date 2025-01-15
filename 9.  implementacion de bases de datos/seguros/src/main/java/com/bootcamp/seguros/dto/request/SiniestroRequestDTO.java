package com.bootcamp.seguros.dto.request;

import com.bootcamp.seguros.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroRequestDTO {
    private LocalDate fecha;
    private double perdida;
    private Vehiculo vehiculo;
}
