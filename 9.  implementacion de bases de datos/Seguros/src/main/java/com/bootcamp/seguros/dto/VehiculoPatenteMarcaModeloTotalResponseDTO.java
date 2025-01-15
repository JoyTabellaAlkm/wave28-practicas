package com.bootcamp.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class VehiculoPatenteMarcaModeloTotalResponseDTO {
    private List<VehiculoPatenteMarcaModeloDTO> vehiculos;
    private Double total;

    public VehiculoPatenteMarcaModeloTotalResponseDTO() {
        vehiculos = new ArrayList<>();
    }
}
