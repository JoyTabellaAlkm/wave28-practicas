package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    ResponseDTO addCar(VehicleDto car);
    ResponseDTO addCars(List<VehicleDto> cars);
    List<VehicleDto> findCarByColorAndYear(String color, int year);
    List<VehicleDto> findCarsByBrandAndYear(String brand, int startYear, int endYear);
    ResponseDTO findAverageMaxSpeedByBrand(String brand);
    ResponseDTO updateMaxSpeed(int id, UpdateSpeedRequesDTO max_speed);
    ResponseDTO deleteCar(int id);
    List<VehicleDto> findVehiclesTransmissionByType(String type);
    ResponseDTO putUpdateByTypeFuel (int id, UpdateFuelByIdRequestDTO fuel);
    AverageCapacityResponseDTO averageByPassengers(String brand);
    List<VehicleDto> findByLarge(String length,String width);
    List<VehicleDto> findCarsByWeight(double min,double max);
}
