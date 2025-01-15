package com.mercadolibre.showroom.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDto {
    private LocalDate fecha;
    private double total;
    @JsonProperty("medio_de_pago")
    private String medioDePago;
    private List<PrendaVentaDto> prendas;
}
