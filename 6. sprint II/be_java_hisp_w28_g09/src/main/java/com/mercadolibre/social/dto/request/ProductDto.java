package com.mercadolibre.social.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    @JsonProperty("product_id")
    @NotNull(message = "El ID no puede estar vacio.")
    @Min(value = 1, message = "El ID debe ser mayor a 0.")
    private Integer productId;
    @JsonProperty("product_name")
    @NotBlank(message = "El nombre no puede estar vacio.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre solo puede contener letras y números (sin caracteres especiales)")
    private String productName;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre solo puede contener letras y números (sin caracteres especiales)")
    private String type;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre solo puede contener letras y números (sin caracteres especiales)")
    private String brand;
    @NotBlank(message = "El campo no puede estar vacio.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre solo puede contener letras y números (sin caracteres especiales)")
    private String color;
    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre solo puede contener letras y números (sin caracteres especiales)")
    private String notes;
}
