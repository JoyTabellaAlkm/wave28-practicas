package com.example.consecionaria.service;

import com.example.consecionaria.dto.VehicleDTO;
import com.example.consecionaria.dto.request.VehicleByDatesRequest;
import com.example.consecionaria.dto.request.VehicleByPricesRequest;

import java.util.List;

public interface IVehicleService {
    VehicleDTO createVehicle(VehicleDTO request);
    List<VehicleDTO> getVehicles();
    List<VehicleDTO> getVehiclesByDate(VehicleByDatesRequest request);
    List<VehicleDTO> getVehiclesByPrices(VehicleByPricesRequest request);
    VehicleDTO getById(int i);
}
