package com.bootcamp.seguros.dto.response;

import com.bootcamp.seguros.entity.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SiniestroResponseDTO {
    private Long id;
    private LocalDate fecha;
    private double perdida;
    private Vehiculo vehiculo;
}
