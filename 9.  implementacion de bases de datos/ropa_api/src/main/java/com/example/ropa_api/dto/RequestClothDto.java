package com.example.ropa_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestClothDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("code")
    private Long code;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("color")
    private String color;

    @JsonProperty("size")
    private String size;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("price")
    private Double price;
}
