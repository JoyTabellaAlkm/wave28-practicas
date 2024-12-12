package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    Vehicle postVehicle(Vehicle vehicleNew);

    List<Vehicle> getVehiclesByDimensions(int minLength, int maxLength, int minWidth, int maxWidth);

    List<Vehicle> vehiclesForBrand(String brand);
}
