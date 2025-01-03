package com.spring1.meliSocial.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"product_id", "product_name", "type", "brand", "color", "notes"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {
    @Min(value = 1, message = "El id del producto debe ser mayor a cero")
    @JsonAlias("product_id")
    private int id;

    @NotBlank(message = "El campo product_name no puede estar vacío")
    @Size(max = 40, message = "La longitud de product_name no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo product_name no puede poseer caracteres especiales")
    @JsonAlias("product_name")
    private String name;

    @NotBlank(message = "El campo type no puede estar vacío")
    @Size(max = 15, message = "La longitud de type no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo type no puede poseer caracteres especiales")
    private String type;

    @NotBlank(message = "El campo brand no puede estar vacío")
    @Size(max = 25, message = "La longitud de brand no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo brand no puede poseer caracteres especiales")
    private String brand;

    @NotBlank(message = "El campo color no puede estar vacío")
    @Size(max = 15, message = "La longitud de color no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo color no puede poseer caracteres especiales")
    private String color;

    @Size(max = 80, message = "La longitud de notes no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]*$", message = "El campo notes no puede poseer caracteres especiales")
    private String notes;
}
