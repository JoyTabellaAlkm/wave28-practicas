package com.example.concesionaria.service;

import com.example.concesionaria.dto.request.VehicleRequestDto;
import com.example.concesionaria.dto.response.VehicleResponseDto;

import java.util.List;

public interface IVehicleService {

    Integer agregarVehiculo(VehicleRequestDto vehiculo);
    List<VehicleResponseDto> obtenerTodosLosVehiculos();
    VehicleResponseDto obtenerPorId(int id);
    List<VehicleResponseDto> obtenerPorFecha(String initialDate, String finalDate);
    List<VehicleResponseDto> obtenerPorPrecio(String initialPrice, String finalPrice);
}
