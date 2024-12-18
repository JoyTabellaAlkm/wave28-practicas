package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class PromoPostCountDto {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("promo_products_count")
    private Integer promoProductCount;
}
