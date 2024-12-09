package com.mercadolibre.concesionario.service;

import com.mercadolibre.concesionario.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO);

    public List<VehicleDTO> getAll();

    List<VehicleDTO> getByDate(LocalDate since, LocalDate to);

    List<VehicleDTO> getByPrice(String since, String to);
    VehicleDTO getVehicleById(String id);
}
