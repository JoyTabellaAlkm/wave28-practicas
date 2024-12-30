package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface IVehicleRepository {

    List<Vehicle> findAll();

    boolean existsById(Long id);

    void save(Vehicle vehicle);

    void DeleteID(Vehicle vehicle);

    Optional<Vehicle> findById(Long id);
}
