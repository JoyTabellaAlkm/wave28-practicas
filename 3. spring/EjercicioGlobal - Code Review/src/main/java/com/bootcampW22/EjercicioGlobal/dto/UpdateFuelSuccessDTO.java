package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFuelSuccessDTO {
    String message;
    VehicleDto vehicleDto;
}
