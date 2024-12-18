package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.BrandSpeedAverageResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.time.LocalDate;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    String addCar(Vehicle car);
    String addCars(List<Vehicle> cars);
    List<Vehicle> findCarByColorAndYear(String color, int year);
    List<Vehicle> findCarsByBrandAndYear(String brand, int startYear, int endYear);
    double calAverageSpeedByBrand(String brand);
    String updateMaxSpeed(int id, String max_speed);
    String deleteCar(Vehicle car);
    List<Vehicle> getVehiclesByTranssmission(String type);
    String putTypeFuel(int id, String car);
    double averageByBrand(String brand);
    List<Vehicle> findByLarge(double minLength,double maxLength,double minWidth,double maxWidth);
    List<Vehicle> findCarsByRangeWeight(double min,double max);
}
