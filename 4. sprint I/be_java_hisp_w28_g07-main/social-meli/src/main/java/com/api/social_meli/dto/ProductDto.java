package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("product_name")
    private String name;
    private String type;
    private String brand ;
    @JsonProperty("color")
    private String colour;
    private String notes;
}
