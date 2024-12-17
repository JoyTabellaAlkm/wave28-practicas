package com.bootcamp.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreationPromoDto {
    @JsonProperty("user_id")
    private Long userId;
    private String date;
    private ProductCreationDto product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private Double discount;
}
