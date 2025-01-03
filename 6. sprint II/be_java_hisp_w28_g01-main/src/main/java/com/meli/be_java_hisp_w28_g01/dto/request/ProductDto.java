package com.meli.be_java_hisp_w28_g01.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto implements Serializable {
    @JsonProperty("product_id")
    @NotNull(message="La id no puede estar vacía.")
    @Min(value = 1, message = "El id debe ser mayor a cero.")
    Integer id;

    @JsonProperty("product_name")
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El campo no puede poseer caracteres especiales.")
    String name;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El campo no puede poseer caracteres especiales.")
    String type;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El campo no puede poseer caracteres especiales.")
    String brand;

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El campo no puede poseer caracteres especiales.")
    String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "El campo no puede poseer caracteres especiales.")
    String notes;
}
