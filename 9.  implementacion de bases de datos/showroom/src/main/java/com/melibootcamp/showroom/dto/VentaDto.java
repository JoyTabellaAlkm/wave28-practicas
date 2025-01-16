package com.melibootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.melibootcamp.showroom.entity.Prenda;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {

    private Long id;

    private LocalDate fecha;

    private double total;

    @JsonProperty("medio_de_pago")
    private String medioDePago;

    @JsonProperty("lista_de_prendas")
    private List<PrendaDto> listaDePrendas;
}
