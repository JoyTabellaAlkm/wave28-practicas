package com.mercadolibre.las_perlas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoyaDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(max = 50, message = "La longitud del nombre de la joya no puede superar los 50 caracteres.")
    private String nombre;

    @NotBlank(message = "El material no puede estar vacío.")
    @Size(max = 50, message = "La longitud del material de la joya no puede superar los 50 caracteres.")
    private String material;

    @Positive
    private Long peso;

    private String particularidad;

    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    @JsonProperty("venta_o_no")
    private Boolean ventaONo;
}
