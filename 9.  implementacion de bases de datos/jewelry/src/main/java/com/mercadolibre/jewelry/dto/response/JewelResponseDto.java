package com.mercadolibre.jewelry.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelResponseDto {
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    @JsonProperty("has_stone")
    private Boolean hasStone;
    @JsonProperty("sale_or_not")
    private Boolean saleOrNot;
}
