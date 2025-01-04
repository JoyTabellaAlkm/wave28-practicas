package com.mercadolibre.socialmeli_g3.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.socialmeli_g3.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @JsonProperty("post_id")
    private int postId;

    @JsonProperty("user_id")
    private int userId;

    private String date;

    private ProductDTO product;

    private int category;

    private double price;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private double discount;
}