package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    String createVehicle(VehicleDto vehicleDto);
}

