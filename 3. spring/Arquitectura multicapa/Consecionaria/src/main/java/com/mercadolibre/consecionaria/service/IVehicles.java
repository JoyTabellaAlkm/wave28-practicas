package com.mercadolibre.consecionaria.service;

import com.mercadolibre.consecionaria.dto.VehiclesDtoResponse;
import com.mercadolibre.consecionaria.dto.VehiclesWithoutServicesDtoResponse;
import com.mercadolibre.consecionaria.entity.Vehicles;

import java.util.List;

public interface IVehicles {
    VehiclesDtoResponse crearVehiculo(Vehicles vehiculo);
    List<VehiclesWithoutServicesDtoResponse> devolverVehiculos();
    List<VehiclesDtoResponse> devolverVehiculosXFecha(String since, String to);
    List<VehiclesDtoResponse> devolverVehiculosXPrecio(int since, int to);
    VehiclesDtoResponse devolverVehiculoXId(int id);
}
