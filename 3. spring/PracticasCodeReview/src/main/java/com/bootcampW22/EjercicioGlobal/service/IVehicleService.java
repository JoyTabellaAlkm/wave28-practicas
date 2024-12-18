package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    public void addNewVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getByColorAndYear(String color, Integer year);
}
