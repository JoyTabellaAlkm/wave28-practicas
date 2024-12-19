package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price"})
public class RecentPostDto {
    @JsonProperty("user_id")
    int userId;

    @JsonProperty("post_id")
    int id;

    LocalDate date;

    RecentProductDto product;

    int category;
    
    double price;
}
