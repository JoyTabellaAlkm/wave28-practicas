package com.mercadolibre.llavecompuesta.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompraDto {

    @JsonProperty("cliente_id")
    private Long clienteId;

    private Long cantidad;
    private Double precio;

}
