package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.FuelDto;
import com.bootcampW22.EjercicioGlobal.dto.SpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    Long saveVehicle(VehicleDto vehicleDto);

    List<VehicleDto> searchByColorAndYear(String color, int year);

    List<VehicleDto> searchByBrandAndRangeYear(String brand, int startYear, int endYear);

    Double searchAverageSpeedByBrand(String brand);

    String saveManyVehicle(List<VehicleDto> vehicleDtos);

    Long updateSpeed(SpeedDto speedDto, Long id);

    List<VehicleDto> searchByFuelType(String type);

    void deleteVehicle(Long id);

    List<VehicleDto> searchByTransmissionType(String type);

    Long updateFuel(FuelDto fuelDto, Long id);

    Double searchAverageCapacityByBrand(String brand);

    List<VehicleDto> searchByDemensions(double min_length, double max_length, double min_width, double max_width);

    List<VehicleDto> searchByWeight(double weight_min, double weight_max);
}
