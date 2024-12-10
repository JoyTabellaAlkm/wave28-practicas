package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto addVehicle(VehicleDto vehicleDto);
    List<VehicleDto> searchVehiclesByColorAndYear(String color, int year);
    List<VehicleDto> searchVehiclesByBrandAndYearRange(String brand, int startYear, int endYear);
    double getAverageSpeedByBrand(String brand);
   // List<VehicleDto> addVehicleBatch(List<VehicleDto> vehiclesDto);
    VehicleDto updateVehicleSpeed(Long id, double newSpeed);
    List<VehicleDto> getVehiclesByFuelType(String type);
    boolean deleteVehicle(Long id);
    List<VehicleDto> getVehiclesByTransmission(String transmission);
    VehicleDto updateVehicleFuel(Long id, String fuel);
    double getAverageCapacityByBrand(String brand);
    List<VehicleDto> getVehiclesByDimension(double min_length,
                                             double max_length,
                                             double min_width,
                                             double max_width);
    List<VehicleDto> getVehiclesByWeight(double min_weight, double max_weight);
    List<VehicleDto> addVehicleBatch(List<VehicleDto> vehiclesDto);
}
