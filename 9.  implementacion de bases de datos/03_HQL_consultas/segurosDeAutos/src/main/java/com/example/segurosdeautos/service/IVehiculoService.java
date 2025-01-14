package com.example.segurosdeautos.service;

import com.example.segurosdeautos.dto.request.VehiculoRequestDto;
import com.example.segurosdeautos.dto.response.VehiculoResponseDto;

import java.util.List;

public interface IVehiculoService {

    VehiculoResponseDto crearVehiculo(VehiculoRequestDto vehiculo);
    List<VehiculoResponseDto> obtenerTodosLosVehiculos();
    VehiculoResponseDto obtenerVehiculoPorId(Long id);
}
