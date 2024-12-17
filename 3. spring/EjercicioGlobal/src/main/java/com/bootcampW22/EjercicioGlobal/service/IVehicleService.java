package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.Request.RequestCreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.Request.RequestUpdateFuelDTO;
import com.bootcampW22.EjercicioGlobal.dto.Request.RequestUpdateSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.Response.AveragePassengersByBrand;
import com.bootcampW22.EjercicioGlobal.dto.Response.AverageSpeedByBrandDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    String addNewVehicle(RequestCreateVehicleDTO vehicle);

    List<VehicleDto> findByColorAndYear(String color, int year);

    List<VehicleDto> findByBrandAndYears(String brand, int start_year, int end_date);

    AverageSpeedByBrandDTO averageSpeedByBrand(String brand);

    String createMultipleVehicles(List<RequestCreateVehicleDTO> vehicles);

    String updateMaxSpeed(Long id, RequestUpdateSpeedDTO speed);

    List<VehicleDto> getVehiclesByFuelType(String type);

    String deleteVehicle(Long id);

    List<VehicleDto> getVehiclesByTransmission(String type);

    String updateFuel(Long id, RequestUpdateFuelDTO fuel);

    AveragePassengersByBrand getAveragePassengersByBrand(String brand);
}
