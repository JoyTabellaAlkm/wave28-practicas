package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price"})
public class RecentPostDto {
    @JsonProperty("user_id")
    int userId;

    @JsonProperty("post_id")
    int id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate date;

    RecentProductDto product;

    int category;

    double price;
}
