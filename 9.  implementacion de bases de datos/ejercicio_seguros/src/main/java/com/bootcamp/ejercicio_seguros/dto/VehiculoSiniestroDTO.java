package com.bootcamp.ejercicio_seguros.dto;

import com.bootcamp.ejercicio_seguros.model.Vehiculo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class VehiculoSiniestroDTO {
    private VehiculoPatenteMarcaModeloDTO vehiculo;
    private Double perdidaTotal;

    public VehiculoSiniestroDTO(VehiculoPatenteMarcaModeloDTO vehiculo, Double perdidaTotal) {
        this.vehiculo = vehiculo;
        this.perdidaTotal = perdidaTotal;
    }
}
