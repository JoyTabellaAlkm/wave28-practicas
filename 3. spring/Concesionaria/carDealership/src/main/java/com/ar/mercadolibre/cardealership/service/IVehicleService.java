package com.ar.mercadolibre.cardealership.service;

import com.ar.mercadolibre.cardealership.dto.response.VehicleBasicDTO;
import com.ar.mercadolibre.cardealership.dto.response.VehicleDTO;
import com.ar.mercadolibre.cardealership.dto.request.VehicleCreationDTO;

import java.util.List;

public interface IVehicleService {
    VehicleDTO create(VehicleCreationDTO vehicleCreationDTO);
    List<VehicleBasicDTO> getAll();
    VehicleDTO getById(Long id);
    List<VehicleDTO> getByPriceRange(String from, String to);
    List<VehicleDTO> getByDateRange(String from, String to);
}
