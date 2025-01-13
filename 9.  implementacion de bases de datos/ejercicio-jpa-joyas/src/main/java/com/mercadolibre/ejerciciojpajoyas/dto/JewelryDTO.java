package com.mercadolibre.ejerciciojpajoyas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelryDTO {

    Long id;

    String name;

    String material;

    Double weight;

    String description;

    @JsonProperty("has_stone")
    Boolean hasStone;

    @JsonProperty("for_sale")
    Boolean forSale;

}
