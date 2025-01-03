package com.mercadolibre.be_java_hisp_w28_g10.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    public static int counterPostId = 50;
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("post_id")
    private int postId;
    private LocalDate date;
    private int category;
    private double price;
    private Product product;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;
}
