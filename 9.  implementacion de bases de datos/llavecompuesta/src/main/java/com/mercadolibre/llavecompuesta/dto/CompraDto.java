package com.mercadolibre.llavecompuesta.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDto {

    @JsonProperty("cliente_id")
    private Long clienteId;

    private LocalDateTime fecha;
    private Long cantidad;
    private Double precio;

}
