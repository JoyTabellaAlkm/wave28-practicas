package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AverageCapacityDto {
    private String brand;
    private double averageCapacity;

}
