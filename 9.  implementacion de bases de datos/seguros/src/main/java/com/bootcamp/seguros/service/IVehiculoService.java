package com.bootcamp.seguros.service;

import com.bootcamp.seguros.dto.request.VehiculoRequestDTO;
import com.bootcamp.seguros.dto.response.VehiculoPatenteYMarcaDTO;
import com.bootcamp.seguros.dto.response.VehiculoResponseDTO;

import java.util.List;

public interface IVehiculoService {
    VehiculoResponseDTO createVehiculo(VehiculoRequestDTO vehiculo);
    List<VehiculoResponseDTO> findAll();

    List<String> findAllPatentes();

    List<VehiculoPatenteYMarcaDTO> findAllPatentesAndMarca();

    List<String> findPatentesRuedasAndAnio(Integer anioActual);
}