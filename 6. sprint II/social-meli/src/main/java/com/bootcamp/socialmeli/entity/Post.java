package com.bootcamp.socialmeli.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    @JsonProperty("user_id")

    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")

    private LocalDate date;

    private Product product;

    private int category;

    @JsonProperty("has_promo")
    private boolean hasPromo;
    
    private double discount;
}
