package com.ar.mercadolibre.cardealership.service;

import com.ar.mercadolibre.cardealership.dto.response.VehicleBasicDTO;
import com.ar.mercadolibre.cardealership.dto.response.VehicleDTO;
import com.ar.mercadolibre.cardealership.dto.request.VehicleCreationDTO;
import com.ar.mercadolibre.cardealership.model.Vehicle;
import com.ar.mercadolibre.cardealership.repository.IVehicleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleDTO create(VehicleCreationDTO vehicleCreationDTO) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicleCreationDTO, Vehicle.class);
        vehicleRepository.create(vehicle);

        return mapper.convertValue(vehicle, VehicleDTO.class);
    }

    @Override
    public List<VehicleBasicDTO> getAll() {
        List<Vehicle> vehicles = vehicleRepository.getAll();
        List<VehicleBasicDTO> vehicleBasicDTOs;

        try {
            if(vehicles.isEmpty()) {
                throw new NoSuchElementException("No vehicles registered");
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                vehicleBasicDTOs = vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleBasicDTO.class)).toList();
                return vehicleBasicDTOs;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VehicleDTO getById(Long id) {
        Vehicle vehicle = vehicleRepository.getById(id);
        try {
            if(vehicle == null) {
                throw new NoSuchElementException("No vehicles registered");
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                return mapper.convertValue(vehicle, VehicleDTO.class);
            }
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VehicleDTO> getByPriceRange(String from, String to) {
        List<Vehicle> vehicles = vehicleRepository.getByPriceRange(from, to);
        List<VehicleDTO> vehicleDTOs;
        try {
            if(vehicles.isEmpty()) {
                throw new NoSuchElementException("No vehicles found with prices between " + from + " and " + to);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                vehicleDTOs = vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).toList();
                return vehicleDTOs;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VehicleDTO> getByDateRange(String from, String to) {
        List<Vehicle> vehicles = vehicleRepository.getByManufacturingDateRange(from, to);
        List<VehicleDTO> vehicleDTOs;
        try {
            if(vehicles.isEmpty()) {
                throw new NoSuchElementException("No vehicles found with prices between " + from + " and " + to);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                vehicleDTOs = vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDTO.class)).toList();
                return vehicleDTOs;
            }
        }
        catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
