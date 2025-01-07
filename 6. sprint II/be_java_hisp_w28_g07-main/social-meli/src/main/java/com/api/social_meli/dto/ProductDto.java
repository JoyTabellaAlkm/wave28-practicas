package com.api.social_meli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class ProductDto {
    @Min(value = 1, message = "El 'product_id' debe ser mayor a cero")
    @NotNull(message = "El 'product_id' no puede estar vacio")
    @JsonProperty("product_id")
    private Integer productId;
    @NotBlank(message = "El campo 'product_name' no puede estar vacio")
    @Size(min = 0, max = 40, message = "La longitud del campo 'product_name' no puede superar los 40 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo 'product_name' no puede poseer caracteres especiales")
    @JsonProperty("product_name")
    private String name;
    @NotBlank(message = "El campo 'type' no puede estar vacio")
    @Size(min = 0, max = 15, message = "La longitud del campo 'type' no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo 'type' no puede poseer caracteres especiales")
    private String type;
    @NotBlank(message = "El campo 'brand' no puede estar vacio")
    @Size(min = 0, max = 25, message = "La longitud del campo 'brand' no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo 'brand' no puede poseer caracteres especiales")
    private String brand ;
    @NotBlank(message = "El campo 'color' no puede estar vacio")
    @Size(min = 0, max = 15, message = "La longitud del campo 'color' no puede superar los 15 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "El campo 'color' no puede poseer caracteres especiales")
    @JsonProperty("color")
    private String colour;
    @Size(min = 0, max = 80, message = "La longitud del campo 'notes' no puede superar los 80 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo 'notes' no puede poseer caracteres especiales")
    private String notes;
}
