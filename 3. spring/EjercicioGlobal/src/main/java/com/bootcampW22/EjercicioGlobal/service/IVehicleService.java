package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleService {
    List<VehicleDto> findAll();
    List<VehicleDto> searchAllVehicles();
    Vehicle findById(Long id);
    List<VehicleDto> findByColorAndYear(String name, int year);
    List<VehicleDto> findByBrandAndAgeRange(String brand, Integer start_year, Integer end_year);
    Double findByAverageSpeedByBrand(String brand);
    List<VehicleDto> findByFuelType(String type);
    List<VehicleDto> findByTransmissionType(String transmission);
    List<VehicleDto> findByDimensions(String length, String width);
    List<VehicleDto> findByWeightRange(double weight_min, double weight_max);
    Double averageCapacityByBrand(String brand);
    String remove(Long id);
    String save(VehicleDto vehicle);
    String saveMany(List<VehicleDto> vehicles);
    String updateMaxSpeed(Long id, VehicleDto vehicleDto);
    String updateFuelType(Long id, VehicleDto vehicleDto);
}
