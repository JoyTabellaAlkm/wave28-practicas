package com.example.seguros_api.service;

import com.example.seguros_api.dto.RequestVehiculoDto;
import com.example.seguros_api.model.Vehiculo;

import java.util.List;

public interface IVehiculosService {
    Vehiculo create(RequestVehiculoDto requestTestCaseDto);

    List<Vehiculo> getAll();
}
