package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromoProductsCountDto {
    @JsonProperty("user_id")
    private Long id;
    @JsonProperty("user_name")
    private String name;
    @JsonProperty("promo_products_count")
    private Integer promoProductCount;

}

