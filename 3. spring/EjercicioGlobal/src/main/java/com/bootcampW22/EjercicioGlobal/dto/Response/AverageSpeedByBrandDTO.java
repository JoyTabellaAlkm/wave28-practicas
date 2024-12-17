package com.bootcampW22.EjercicioGlobal.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AverageSpeedByBrandDTO {
    private String brand;
    private double averageSpeed;
}
