package com.example.concesionaria.service.impl;

import com.example.concesionaria.dto.request.VehicleRequestDTO;
import com.example.concesionaria.dto.response.MessageDTO;
import com.example.concesionaria.dto.response.VehicleServicesDTO;
import com.example.concesionaria.dto.response.VehicleResponseDTO;
import com.example.concesionaria.exception.NotFoundException;
import com.example.concesionaria.model.Vehicle;
import com.example.concesionaria.repository.IVehicleRepository;
import com.example.concesionaria.service.IVehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    ModelMapper modelMapper = new ModelMapper();

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public MessageDTO createVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle = modelMapper.map(vehicleRequestDTO, Vehicle.class);
        vehicle.setVServices(new ArrayList<>());
        vehicleRepository.save(vehicle);
        return new MessageDTO("Vehículo creado correctamente.");
    }

    @Override
    public VehicleResponseDTO getVehicleById(String license) {
        Vehicle vehicle = findVehicleByLicense(license);
        return modelMapper.map(vehicle, VehicleResponseDTO.class);
    }

    @Override
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(v -> modelMapper.map(v, VehicleResponseDTO.class))
                .toList();
    }

    @Override
    public MessageDTO deleteVehicle(String license) {
        Vehicle vehicle = findVehicleByLicense(license);
        vehicleRepository.delete(vehicle);
        return new MessageDTO("Vehículo eliminado correctamente.");
    }

    @Override
    public VehicleServicesDTO getVehicleRepairs(String license) {
        Vehicle vehicle = findVehicleByLicense(license);
        return modelMapper.map(vehicle, VehicleServicesDTO.class);
    }

    @Override
    public MessageDTO addVehicleRepair(String license, VehicleRequestDTO vehicleRequestDTO) {

        return null;
    }


    private Vehicle findVehicleByLicense(String license) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(license);
        if(vehicle.isEmpty()) {
            throw new NotFoundException("No se ha encontrado el vehículo.");
        }
        return vehicle.get();
    }

}
