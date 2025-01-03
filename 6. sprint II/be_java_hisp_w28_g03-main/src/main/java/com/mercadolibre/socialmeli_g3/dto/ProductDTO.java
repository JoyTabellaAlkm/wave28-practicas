package com.mercadolibre.socialmeli_g3.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotNull(message = "The product id must be provided")
    @Positive(message = "The product id must be a positive number")
    @JsonProperty("product_id")
    private Integer productId;

    @NotBlank(message = "The product name must be provided")
    @Size(max=40, message = "The product name must be between 0 and 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\p{Punct}]*$", message = "The product name must be alphanumeric")
    @JsonProperty("product_name")
    private String productName;

    @NotBlank(message = "The type must be provided")
    @Size(max=15, message = "The type must be between 0 and 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\p{Punct}]*$", message = "The type name must be alphanumeric")
    private String type;

    @NotBlank(message = "The brand must be provided")
    @Size(max=25, message = "The brand must be between 0 and 25 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\p{Punct}]*$", message = "The brand name must be alphanumeric")
    private String brand;

    @NotBlank(message = "The color must be provided")
    @Size(max=15, message = "The color must be between 0 and 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\p{Punct}]*$", message = "The color name must be alphanumeric")
    private String color;

    @Size(max=80, message = "The notes must be between 0 and 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s\\p{Punct}]*$", message = "The notes must be alphanumeric")
    private String notes;
}