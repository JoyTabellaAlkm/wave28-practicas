package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    List<VehicleDto> findByColorAndYear(String color, int year);
    List <VehicleDto> findByBrandAndYear ( String brand, int start_year, int end_year);
    List <VehicleDto> findByTypeTransmission (String transmission);
}
