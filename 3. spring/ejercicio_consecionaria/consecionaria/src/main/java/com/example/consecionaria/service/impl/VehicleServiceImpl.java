package com.example.consecionaria.service.impl;

import com.example.consecionaria.dto.VehicleDTO;
import com.example.consecionaria.dto.request.VehicleByDatesRequest;
import com.example.consecionaria.dto.request.VehicleByPricesRequest;
import com.example.consecionaria.entity.Vehicle;
import com.example.consecionaria.repository.IVehicleRepository;
import com.example.consecionaria.service.IVehicleService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public VehicleDTO createVehicle(VehicleDTO request) {
        Vehicle newVehicle = objectMapper.convertValue(request, Vehicle.class);
        vehicleRepository.create(newVehicle);
        return request;
    }

    @Override
    public List<VehicleDTO> getVehicles() {
        return objectMapper.convertValue(
                vehicleRepository.getAll(),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VehicleDTO> getVehiclesByDate(VehicleByDatesRequest request) {
        return objectMapper.convertValue(
                vehicleRepository.getByManufacturingDate(request.getSince(), request.getTo()),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VehicleDTO> getVehiclesByPrices(VehicleByPricesRequest request) {
        return objectMapper.convertValue(
                vehicleRepository.getByPrices(request.getSince(), request.getTo()),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public VehicleDTO getById(int id) {
        return objectMapper.convertValue(
                vehicleRepository.getById(id),
                new TypeReference<>() {}
        );
    }
}
