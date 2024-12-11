package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface IVehicleRepository {
    List<Vehicle> findAll();

    String addVehicle(Vehicle vehicle);

    Optional<Vehicle> findId(Long id);
}

