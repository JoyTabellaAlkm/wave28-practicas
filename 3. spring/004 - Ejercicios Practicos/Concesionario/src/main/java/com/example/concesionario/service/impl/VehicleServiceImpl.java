package com.example.concesionario.service.impl;

import com.example.concesionario.dto.VehicleDTO;
import com.example.concesionario.model.Vehicle;
import com.example.concesionario.repository.VehicleRepository;
import com.example.concesionario.service.ServiceService;
import com.example.concesionario.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ServiceService serviceService;

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {
        System.out.println();
        Vehicle vehicle =  vehicleRepository.createVehicle(toModel(vehicleDTO));
        return toDto(vehicle);
    }

    @Override
    public List<VehicleDTO> getAll() {
        return vehicleRepository.getAll().stream().map(this::toDto).toList();
    }

    @Override
    public List<VehicleDTO> getByDate(LocalDate since, LocalDate to) {
        return vehicleRepository.getAll().stream()
                .filter(
                        v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
                .map(this::toDto).toList();
    }


    private Vehicle toModel(VehicleDTO vehicleDTO){
        System.out.println(vehicleDTO.getServices().toString());
        return new Vehicle(null,vehicleDTO.getBrand(), vehicleDTO.getModel(),
                vehicleDTO.getManufacturingDate(),vehicleDTO.getNumberOfKilometers(),
                vehicleDTO.getDoors(), vehicleDTO.getPrice(), vehicleDTO.getCurrency(),
                serviceService.serviceListToDto(vehicleDTO.getServices()),vehicleDTO.getCountOfOwners());
    }
    private VehicleDTO toDto(Vehicle vehicle){
        return new VehicleDTO(vehicle.getBrand(), vehicle.getModel(),
                vehicle.getManufacturingDate(),vehicle.getNumberOfKilometers(),
                vehicle.getDoors(), vehicle.getPrice(), vehicle.getCurrency(),
                serviceService.serviceListToModel(vehicle.getServices()),vehicle.getCountOfOwners());
    }

}
