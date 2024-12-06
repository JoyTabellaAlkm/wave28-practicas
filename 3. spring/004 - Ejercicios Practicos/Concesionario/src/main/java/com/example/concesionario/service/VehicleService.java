package com.example.concesionario.service;

import com.example.concesionario.dto.VehicleDTO;

import java.time.LocalDate;
import java.util.List;

public interface VehicleService {
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO);

    public List<VehicleDTO> getAll();

    List<VehicleDTO> getByDate(LocalDate since, LocalDate to);
}
