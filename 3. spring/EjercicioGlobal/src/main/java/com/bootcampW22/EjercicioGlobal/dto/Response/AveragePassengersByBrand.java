package com.bootcampW22.EjercicioGlobal.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AveragePassengersByBrand {
    private String brand;
    private double average;
}
