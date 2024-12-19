package com.spring1.meliSocial.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring1.meliSocial.dto.response.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class RequestPostDto {
    private int id;
    @JsonAlias("user_id")
    private int userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price; //precio original
}
