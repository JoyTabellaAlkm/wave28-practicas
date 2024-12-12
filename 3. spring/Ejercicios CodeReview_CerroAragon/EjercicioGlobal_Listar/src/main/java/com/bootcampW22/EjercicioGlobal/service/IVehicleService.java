package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AvarageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.dto.AvarageCapacityDto;
import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    List<VehicleDto> findByFuelType(String fuelType); // Nuevo método
    List<VehicleDto> findByWeightRange(double minWeight, double maxWeight);
    AvarageCapacityDto calculateAverageCapacityByBrand(String brand);
    AvarageSpeedDto calculateAverageSpeedByBrand (String brand);
}
