package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Long addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle);
}