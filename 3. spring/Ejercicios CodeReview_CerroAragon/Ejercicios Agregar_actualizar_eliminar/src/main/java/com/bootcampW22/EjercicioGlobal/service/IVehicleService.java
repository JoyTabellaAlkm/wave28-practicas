package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    String addVehicle(VehicleDto vehicleDto);

    String addVehicles(List<VehicleDto> vehicleDtoList);

    String deleteVehicle(Long id);

    String updateMax_speed(Long id, String maxSpeed);

    String updateByIdFuel(Long id, String fuel_type);

}