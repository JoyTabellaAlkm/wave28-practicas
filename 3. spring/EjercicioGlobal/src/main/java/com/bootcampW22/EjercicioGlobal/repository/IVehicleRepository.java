package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    boolean add(Vehicle vehicle);
    List<Vehicle> findVehicleByColorAndYear(String color, int year);
    List<Vehicle> findVehicleByBrandAndYearRange(String brand, int startYear, int endYear);
    List<Vehicle> findVehiclesByBrand(String brand);
    boolean vehicleExists(Vehicle vehicle);
    boolean addAll(List<Vehicle> vehicles);
    Vehicle findById(Long id);
    List<Vehicle> findVehicleByFuelType(String type);
    boolean delete(Vehicle vehicle);
    List<Vehicle> getVehiclesByTransmission(String transmission);
    List<Vehicle> getVehiclesByDimension(double min_length, double max_length, double min_width, double max_width);
    List<Vehicle> getVehiclesByWeight(double min_weight, double max_weight);
    boolean vehicleAlreadyExists(Long id);
    boolean addVehicleBatch(List<Vehicle> vehicles);
}
