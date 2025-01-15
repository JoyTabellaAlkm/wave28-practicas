package com.example.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDto {

    @JsonProperty("medio_de_pago")
    private String medioDePago;

    private List<PrendaWithCodeDto> prendas;

}
