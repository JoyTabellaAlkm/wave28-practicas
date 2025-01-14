package com.example.concesionaria.service;

import com.example.concesionaria.dto.request.VehicleRequestDTO;
import com.example.concesionaria.dto.response.MessageDTO;
import com.example.concesionaria.dto.response.VehicleServicesDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;

import java.util.List;

public interface IVehicleService {

    MessageDTO createVehicle(VehicleRequestDTO vehicleRequestDTO);

    VehicleResponseDTO getVehicleById(String license);

    List<VehicleResponseDTO> getAllVehicles();

    MessageDTO deleteVehicle(String license);

    VehicleServicesDTO getVehicleRepairs(String license);

    MessageDTO addVehicleRepair(String license, VehicleRequestDTO vehicleRequestDTO);

}
