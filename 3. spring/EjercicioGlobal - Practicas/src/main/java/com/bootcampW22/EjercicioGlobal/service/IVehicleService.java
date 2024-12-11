package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> searchAllVehiclesByColorAndYear(String color, int year);

    List<VehicleDto> searchAllVehiclesByBrandBetweenYears(String brand, int startYear, int endYear);

    AverageSpeedDto findAverageSpeedOfBrand(String brand);

    List<VehicleDto> createVehicleBatch(List<VehicleDto> vehicleDtoList);

    List<VehicleDto> findVehiclesByDimensions(String length, String width);
}
