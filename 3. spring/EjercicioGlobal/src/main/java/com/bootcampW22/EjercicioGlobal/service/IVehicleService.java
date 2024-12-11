package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> findAll();
    String save(VehicleDto vehicle);
    List<VehicleDto> findByColorAndYear(String color, int year);
    List<VehicleDto> findByBrandAndBetweenYear(String brand, int startYear, int endYear);
    Double averageSpeedByBrand(String brand);
    String multipleSaving(List<VehicleDto> vehicles);
    String updateMaxSpeed(Long id, VehicleDto vehicleDto);
    List<VehicleDto> findByFuelType(String fuelType);
    String remove(Long id);
    List<VehicleDto> findByTransmissionType(String transmissionType);
    String updateFuelType(Long id, VehicleDto vehicleDto);
    Double averageCapacityByBrand(String brand);
    List<VehicleDto> findByDimensions(String length, String width);
    List<VehicleDto> findByWeightRange(double minWeight, double maxWeight);
}
