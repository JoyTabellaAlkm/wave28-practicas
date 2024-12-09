package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.io.IOException;
import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    String save(Vehicle vehicle) throws IOException;
    void update(List<Vehicle> vehicleList);
    void delete(List<Vehicle> vehicleList);
}
