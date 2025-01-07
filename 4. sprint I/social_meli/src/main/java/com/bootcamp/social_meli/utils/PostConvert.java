package com.bootcamp.social_meli.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostConvert {
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate createDate;
    @JsonProperty("product_id")
    private Long productId;
    private Integer category;
    @JsonProperty("has_promo")
    private Boolean hasDiscount;
    @JsonProperty("discount")
    private Double discountPercentage;
    private Double price;
}