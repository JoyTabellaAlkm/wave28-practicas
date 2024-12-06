package com.bootcamp.concesionariaautos.service;

import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.dto.response.VehicleResponseFindAllDTO;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<VehicleResponseFindAllDTO> findAll();
    VehicleDTO findById(Long id);
    VehicleDTO save(VehicleDTO vehicleDTO);
    VehicleDTO update(VehicleDTO vehicleDTO);
    VehicleDTO deleteById(Long id);
}
