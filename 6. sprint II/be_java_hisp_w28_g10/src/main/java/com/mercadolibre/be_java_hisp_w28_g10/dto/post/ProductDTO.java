package com.mercadolibre.be_java_hisp_w28_g10.dto.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(message = "El id no puede estar vacío.")
    @Positive(message = "El id debe ser mayor a cero.")
    @JsonProperty("product_id")
    private Integer id;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[^%&$#@!¡¿?()={},.<>]*$", message = "El campo no puede poseer caracteres especiales.")
    @JsonProperty("product_name")
    private String name;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[^%$#@!¡¿?()={},.<>]*$", message = "El campo no puede poseer caracteres especiales.")
    private String type;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[^%$#@!¡¿?()={},.<>]*$", message = "El campo no puede poseer caracteres especiales.")
    private String brand;

    @NotBlank(message = "El campo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[^%$#@!¡¿?()={},.<>]*$", message = "El campo no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[^%$#@!¡¿?()={},.<>]*$", message = "El campo no puede poseer caracteres especiales.")
    private String notes;
}
