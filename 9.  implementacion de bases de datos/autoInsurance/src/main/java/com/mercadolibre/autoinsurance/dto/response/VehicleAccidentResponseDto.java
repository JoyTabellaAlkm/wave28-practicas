package com.mercadolibre.autoinsurance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleAccidentResponseDto {
    private VehicleResponseDto vehicleResponseDto;
    private double totalLoss;
}
