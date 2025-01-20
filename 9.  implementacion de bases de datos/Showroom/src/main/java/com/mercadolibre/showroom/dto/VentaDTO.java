package com.mercadolibre.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Long code;
    private LocalDate fecha;
    private Double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    private List<PrendaDTO> prendas;
}
