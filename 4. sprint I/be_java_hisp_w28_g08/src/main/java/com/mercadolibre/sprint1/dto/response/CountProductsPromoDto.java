package com.mercadolibre.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountProductsPromoDto {
    @JsonProperty("user_id")
	private int id;

	@JsonProperty("user_name")
	private String name;

    @JsonProperty("promo_products_count")
    private long promoProductsCount;
}
