package com.mercadolibre.jewelry.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JewelRequestDto {

    @NotBlank(message = "El nombre de la joya no debe estar en vacío o nulo")
    @Size(min = 3, max = 100, message = "El nombre de la joya debe tener entre 3 y 100 caracteres")
    private String name;
    @NotBlank(message = "El material de la joya no debe estar en vacío o nulo")
    @Size(min = 3, max = 100, message = "El material de la joya debe tener entre 3 y 100 caracteres")
    private String material;
    @NotNull(message = "El peso de la joya no debe ser nulo")
    @Positive(message = "El peso de la joya deb ser un número mayor a 0")
    private Double weight;
    private String particularity;
    @NotNull(message = "Se debe especificar true o false para el atributo has_stone")
    @JsonProperty("has_stone")
    private Boolean hasStone;
}
