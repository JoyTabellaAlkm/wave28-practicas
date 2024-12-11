package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    String save(Vehicle vehicle);

    List<Vehicle> findByColorAndYear(String color, int year);

    List<Vehicle> findByBrandAndBetweenYear(String brand, int startYear, int endYear);

    OptionalDouble averageSpeedByBrand(String brand);

    String multipleSaving(List<Vehicle> vehicles);

    String updateMaxSpeed(Vehicle vehicle, String speed);

    List<Vehicle> findByFuelType(String fuelType);

    String remove(Vehicle vehicle);

    List<Vehicle> findByTransmissionType(String transmissionType);

    String updateFuelType(Vehicle vehicle, String fuelType);

    OptionalDouble averageCapacityByBrand(String brand);

    List<Vehicle> findByDimensions(double minLength, double maxLength, double minWidth, double maxWidth);

    List<Vehicle> findByWeightRange(double minWeight, double maxWeight);

    Optional<Vehicle> findById(Long id);
}
