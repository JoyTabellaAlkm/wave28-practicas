package com.mercadolibre.Insurance.dto.response;

import com.mercadolibre.Insurance.entity.Vehiculo;
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
