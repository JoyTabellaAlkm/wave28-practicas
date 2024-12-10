package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Long create(Vehicle vehicle);

    List<Vehicle> findByColorAndYear(String color, int year);

    List<Vehicle> findByBrandAndRangeYear(String brand, int startYear, int endYear);

    Double findAverageSpeedByBrand(String brand);

    Vehicle findById(Long id);

    Long updateSpeed(Vehicle vehicle, String speed);

    List<Vehicle> findByFuelType(String type);

    void delete(Long id);

    List<Vehicle> findByTransmissionType(String type);

    Long updateFuel(Vehicle vehicle, String fuel);

    Double findAverageCapacityByBrand(String brand);

    List<Vehicle> findByDimensions(double min_length, double max_length, double min_width, double max_width);

    List<Vehicle> findByWeight(double weight_min, double weight_max);
}
