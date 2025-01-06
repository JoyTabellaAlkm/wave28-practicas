package com.bootcamp.social_meli.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Long id;
    private User creatorUser;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate createDate;
    private Product product;
    private Integer category;
    private Double price;
    @JsonProperty("has_promo")
    private Boolean hasDiscount;
    @JsonProperty("discount")
    private Double discountPercentage;

    public boolean productNameContains(String productName) {
        String postProductName = product.getName().toLowerCase();
        return postProductName.contains(productName.toLowerCase());
    }
}
