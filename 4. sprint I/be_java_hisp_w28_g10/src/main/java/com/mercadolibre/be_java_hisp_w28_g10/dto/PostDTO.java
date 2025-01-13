package com.mercadolibre.be_java_hisp_w28_g10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("post_id")
    private int postId;
    private String date;
    private int category;
    private double price;
    private ProductDTO product;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
