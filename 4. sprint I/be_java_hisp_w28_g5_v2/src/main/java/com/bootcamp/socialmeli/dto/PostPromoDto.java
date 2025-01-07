package com.bootcamp.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PostPromoDto {
    @JsonProperty("post_id")
    private Long id;
    private String date;
    private Integer category;
    private Double price;
    private ProductDto product;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private Double discount;
}
