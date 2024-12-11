package com.bootcamp.practicacodereviewi.service;

import com.bootcamp.practicacodereviewi.dto.VehicleDto;
import com.bootcamp.practicacodereviewi.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    VehicleDto createVehicle(VehicleDto vehicleDto);

    List<VehicleDto> searchVehiclesByColourAndYear(String color, int year);
    List<VehicleDto> searchVehiclesByBrandAndRangeOfYears(String brand, int fromYear, int toYear);
    double getAverageSpeedFromBrand(String brand);

    List<VehicleDto> createListOfVehicles(List<VehicleDto> vehicles);

    List<VehicleDto> searchVehiclesByDimensions(double minWidth, double maxWidth, double minHeigth, double maxHeigth);

    void deleteVehicle(Long id);

    VehicleDto updateVehicleMaxSpeed(Long id, String newMaxSpeed);
}
