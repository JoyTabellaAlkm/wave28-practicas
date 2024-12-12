package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();
    VehicleDto crearVehiculo(Vehicle vehiculo);
    List<VehicleDto> vehiculoColoryAnio(String color, int year);
    List<VehicleDto> vehiculoMarcayAnio(String marca, int start_year, int end_year);
    String promedioVelocidadxMarca(String brand);
    String crearVehiculos(List<Vehicle> vehiculos);
    String eliminarVehiculo(int id);
    VehicleDto actualizarVelocidad(int id, int velocidad);
    String actualizarCombustible(int id);
}
