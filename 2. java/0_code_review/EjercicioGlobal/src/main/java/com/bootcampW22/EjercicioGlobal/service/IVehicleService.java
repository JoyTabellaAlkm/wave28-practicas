package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.io.IOException;
import java.util.List;
import java.util.OptionalDouble;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    String saveVehicle(Vehicle vehicle) throws IOException;
    List<VehicleDto> findVehiclesByColorAndYear(String color, Integer year);
    List<VehicleDto> findVehiclesByBrandAndYears(String brand, Integer startYear, Integer endYear);
    Double averageSpeedByBrand(String brand);
    String saveVehiclesBatch (List<Vehicle> vehicleList);
    String updateSpeed(Long id, String speed);
    List<VehicleDto> findVehicleByFuel(String fuel);
    String deleteVehicle(Long id);
    List<VehicleDto> findVehiclesByTransmission(String transmission);
    String updateFuel (Long id, String fuel);
    Double averageCapacityByBrand(String brand);
    List<VehicleDto> findVehiclesByDimension(Double minLength, Double maxLength, Double minWidth,
                                             Double maxWidth);
    List<VehicleDto> findVehiclesByWeight(Double minWeight, Double maxWeight);
}
