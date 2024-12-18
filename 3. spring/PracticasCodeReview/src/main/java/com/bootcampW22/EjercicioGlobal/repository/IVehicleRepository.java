package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    void addNew(VehicleDto vehicleDto);

    VehicleDto getById(Long id);

    List<VehicleDto> getByColorAndYear(String color, Integer year);
}
