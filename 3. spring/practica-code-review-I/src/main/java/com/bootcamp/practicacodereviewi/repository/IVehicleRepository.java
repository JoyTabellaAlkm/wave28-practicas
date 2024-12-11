package com.bootcamp.practicacodereviewi.repository;


import com.bootcamp.practicacodereviewi.dto.VehicleDto;
import com.bootcamp.practicacodereviewi.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle createVehicle(VehicleDto vehicleDto);

    List<Vehicle> createListOfVehicles(List<VehicleDto> vehiclesDtos);

    boolean deleteVehicle(Long id);

    Vehicle updateVehicle(Long idUpdatedVehicle, Vehicle newVehicle);
}
