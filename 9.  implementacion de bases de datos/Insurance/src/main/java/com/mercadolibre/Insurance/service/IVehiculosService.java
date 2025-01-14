package com.mercadolibre.Insurance.service;

import com.mercadolibre.Insurance.dto.request.VehiculoRequestDTO;
import com.mercadolibre.Insurance.dto.response.VehiculoResponseDTO;

import java.util.List;

public interface IVehiculosService {
    VehiculoResponseDTO createVehiculo(VehiculoRequestDTO vehiculo);
    List<VehiculoResponseDTO> findAll();
}
