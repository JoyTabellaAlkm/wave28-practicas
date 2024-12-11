package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto addVehicle(VehicleDto vehicle);

    List<VehicleDto> searchByColorAndYear(String color, String year);

    VehicleDto updateSpeed(String id, String newSpeed);

    List<VehicleDto> listByWeightRange(Double min, Double max);
}
