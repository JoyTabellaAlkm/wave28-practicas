package com.bootcamp.social_meli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @JsonProperty("product_id")
    @NotNull(message = "El id de producto no puede ser nulo")
    private Long id;
    @JsonProperty("product_name")
    @NotNull(message = "El nombre de procuto no puede ser nulo")
    private String name;
    @NotNull(message = "El tipo de procuto no puede ser nulo")
    private String type;
    @NotNull(message = "La marca de procuto no puede ser nulo")
    private String brand;
    @NotNull(message = "El color de procuto no puede ser nulo")
    private String color;
    @NotNull(message = "Las notas de procuto no puede ser nulo")
    private String notes;
}
