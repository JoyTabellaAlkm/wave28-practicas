package com.mercadolibre.sprint1.dto.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.sprint1.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromoDto {

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("post_id")
    private int id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    private ProductDto product;

    private int category;

    private double price;

    @JsonProperty("has_promo")
    private boolean hasPromo;

    private double discount;
}
