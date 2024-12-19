package com.bootcamp.socialmeli.dto.request;

import com.bootcamp.socialmeli.dto.response.ProductDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private int id;

    @JsonProperty("user_id")
    private int userId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private ProductDto product;

    private int category;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private double discount;
    
    private double price;
}
