package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    List<Vehicle> findAll();
    Vehicle crearVehiculo(Vehicle vehiculo);
    void crearVehiculos(List<Vehicle> vehiculos);
    Vehicle actualizarVelocidad(int id, int velocidad);
    Vehicle findById(long id);
    Vehicle eliminarVehiculo(int id);

}
