package com.spring1.meliSocial.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring1.meliSocial.dto.response.ProductDto;
import com.spring1.meliSocial.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPromoDto {
    @JsonAlias("user_id")
    private int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    @JsonAlias("has_promo")
    private boolean hasPromo;
    private double discount;
}
