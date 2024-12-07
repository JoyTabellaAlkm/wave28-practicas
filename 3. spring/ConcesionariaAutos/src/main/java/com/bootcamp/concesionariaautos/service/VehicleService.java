package com.bootcamp.concesionariaautos.service;

import com.bootcamp.concesionariaautos.dto.VehicleDTO;
import com.bootcamp.concesionariaautos.dto.VehicleDTONoServices;

import java.util.List;

public interface VehicleService {
    List<VehicleDTONoServices> findAll();
    VehicleDTO findById(Long id);
    VehicleDTO save(VehicleDTO vehicleDTO);
    VehicleDTO update(VehicleDTO vehicleDTO);
    VehicleDTO deleteById(Long id);
}
