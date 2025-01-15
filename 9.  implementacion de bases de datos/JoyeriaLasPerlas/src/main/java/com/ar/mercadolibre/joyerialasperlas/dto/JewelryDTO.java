package com.ar.mercadolibre.joyerialasperlas.dto;

import com.ar.mercadolibre.joyerialasperlas.entity.Material;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JewelryDTO {
    private Long jewelryId;
    private String name;
    private Material material;
    private Double weight;
    private String particularity;
    @JsonProperty("posses_stone")
    private Boolean possesStone;
    @JsonProperty("is_on_sale")
    private Boolean isOnSale;
}
