package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto postAVehicle(VehicleDto vehicle);

    List<VehicleDto> searchVehiclesByDimensions(String length, String width);

    Double averageCapacity(String brand);
}
