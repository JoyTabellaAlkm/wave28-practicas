package com.mercadolibre.ejercicioseguroautos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class VehiculosYTotalDTO {

    private List<VehiculoDTO> vehiculos;

    @JsonProperty("total_perdidas")
    private Double totalPerdidas;

}
