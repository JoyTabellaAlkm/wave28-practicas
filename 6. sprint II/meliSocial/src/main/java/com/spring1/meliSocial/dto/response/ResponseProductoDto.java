package com.spring1.meliSocial.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"product_id", "product_name", "type", "brand", "color", "notes"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseProductoDto {
    @JsonAlias("product_id")
    private int id;
    @JsonAlias("product_name")
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
