package com.demo.LasPerlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
public class JewelDto {
    @JsonProperty("nombre")
    private String name;
    private String material;
    @JsonProperty("peso")
    private Double weight;
    @JsonProperty("particularidad")
    private String particularity;
    @JsonProperty("posee_piedra")
    private Boolean hasStone;
    @JsonProperty("ventaONo")
    private boolean saleOrNot = true;
}
