package com.bootcamp.Showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClothDto {
    private Integer code;
    private String name;
    private String type;
    private String brand;
    private Integer stock;
    @JsonProperty("sale_price")
    private Double salePrice;
}
