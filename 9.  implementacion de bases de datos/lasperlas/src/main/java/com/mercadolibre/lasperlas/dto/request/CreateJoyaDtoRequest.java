package com.mercadolibre.lasperlas.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJoyaDtoRequest {

    @NotBlank
    private String nombre;

    @NotBlank
    private String material;

    @Min(0)
    private double peso;

    @NotBlank
    private String particularidad;

    @JsonProperty("posee_piedra")
    private boolean poseePiedra;

    @JsonProperty("venta_o_no")
    private boolean ventaONo;

}
