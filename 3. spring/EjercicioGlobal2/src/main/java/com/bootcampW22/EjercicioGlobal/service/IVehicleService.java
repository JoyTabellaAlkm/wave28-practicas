package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.SpeedAvergeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleCreateDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;
import java.util.Map;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    void addVehicle(VehicleDto vehicleDto);

    List<VehicleDto> findVehiculoWithColorYear (String color, int year);

    List<VehicleDto> findVehiculoWithBrandYears (String brand, int start_year, int end_year);

    SpeedAvergeDto averageSpeedWithBrand (String brand);
}
