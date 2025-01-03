package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.springframework.http.HttpStatusCode;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    public void addNewVehicle(VehicleDto vehicleDto);

    List<VehicleDto> getByColorAndYear(String color, Integer year);

    List<VehicleDto> findBetweenYears(String brand, Integer startYear, Integer endYear);

    ResponseDTO findAverageSpeedByBrand(String brand);

    ResponseDTO postMultipleVehicles(List<VehicleDto> vehicles);

    ResponseDTO updateSpeed(Double speed, Long id);
}
