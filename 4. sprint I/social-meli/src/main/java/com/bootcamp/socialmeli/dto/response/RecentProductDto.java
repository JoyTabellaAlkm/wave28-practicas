package com.bootcamp.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"product_id", "product_name", "type", "brand", "color", "notes"})
public class RecentProductDto {
    @JsonProperty("product_id")
    int id;

    @JsonProperty("product_name")
    String name;

    String type;

    String brand;

    String color;
    
    String notes;
}
