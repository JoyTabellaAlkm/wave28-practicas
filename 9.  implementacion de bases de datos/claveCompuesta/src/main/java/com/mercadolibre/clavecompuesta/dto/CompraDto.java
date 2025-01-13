package com.mercadolibre.clavecompuesta.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {
    private Long clienteId;
    private LocalDate fecha;
    private String detalles;
    private Double total;
}
