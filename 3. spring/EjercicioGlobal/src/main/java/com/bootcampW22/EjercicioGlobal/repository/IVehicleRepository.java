package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Optional<Vehicle> findById(Long id);
    List<Vehicle> findByColorAndYear(String color, int year);
    List<Vehicle> findByBrandAndAgeRange(String brand, Integer start_year, Integer end_year);
    Double findByAverageSpeedByBrand(String brand);
    List<Vehicle> findByFuelType(String type);
    List<Vehicle> findByTransmissionType(String transmission);
    List<Vehicle> findByDimensions(double min_length, double max_length, double min_width, double max_width);
    List<Vehicle> findByWeightRange(double weight_min, double weight_max);
    Double averageCapacityByBrand(String brand);
    String remove(Vehicle vehicle);
    String save(Vehicle vehicle);
    String saveMany(List<Vehicle> vehicles);
    String updateMaxSpeed(Vehicle vehicle, String max_speed);
    String updateFuelType(Vehicle vehicle, String fuel_type);
}
