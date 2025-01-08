package com.meli.be_java_hisp_w28_g01.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Post {

    int id;
    @JsonProperty("seller")
    Seller seller;
    @JsonProperty("date")
    LocalDate date;
    @JsonProperty("product")
    Product product;
    @JsonProperty("category")
    int category;
    @JsonProperty("price")
    double price;
}
