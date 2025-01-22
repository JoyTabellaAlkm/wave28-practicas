package com.example.Concesionario.service.impl;

import com.example.Concesionario.dto.ServiceVehiclesIdDto;
import com.example.Concesionario.dto.VehicleAllDto;
import com.example.Concesionario.dto.VehicleIdDto;
import com.example.Concesionario.dto.request.CreateVehicleDto;
import com.example.Concesionario.model.ServiceModel;
import com.example.Concesionario.model.Vehicle;
import com.example.Concesionario.respository.VehicleRepository;
import com.example.Concesionario.service.IVehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VehiclesServiceImpl implements IVehiclesService {

    @Autowired
    private VehicleRepository vehicleRepository;

    private VehicleAllDto convert(Vehicle v) {
        VehicleAllDto vehicleDto = new VehicleAllDto();
        vehicleDto.setId(v.getId());
        vehicleDto.setDoors(v.getDoors());
        vehicleDto.setModel(v.getModel());
        vehicleDto.setBrand(v.getBrand());
        vehicleDto.setPrice(v.getPrice());
        vehicleDto.setEntryDate(v.getEntryDate());
        vehicleDto.setMileage(v.getMileage());

        return vehicleDto;
    }

    @Override
    public Vehicle createVehicle(CreateVehicleDto createVehiculoDto) {
        Vehicle vehicle = new Vehicle();

        vehicle.setServiceModels(createVehiculoDto.getServices().stream().map(s -> {
            ServiceModel serviceModel = new ServiceModel();
            serviceModel.setId(0);
            serviceModel.setDate(s.getDate());
            serviceModel.setDescriptions(s.getDescriptions());
            serviceModel.setMileage(s.getMileage());

            return serviceModel;
        }).toList());

        vehicle.setBrand(createVehiculoDto.getBrand());
        vehicle.setDoors(createVehiculoDto.getDoors());
        vehicle.setEntryDate(createVehiculoDto.getEntryDate());
        vehicle.setMileage(createVehiculoDto.getMileage());
        vehicle.setModel(createVehiculoDto.getModel());
        vehicle.setPrice(createVehiculoDto.getPrice());

        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleAllDto> listAllVehicles() {
        return vehicleRepository.listAll().stream().map(this::convert).toList();
    }

    @Override
    public List<VehicleAllDto> listAllVehiclesByDate(LocalDate since, LocalDate to) {
        return vehicleRepository.listAll().stream().filter(vehicle -> {
            return vehicle.getEntryDate().isAfter(since) && vehicle.getEntryDate().isBefore(to);
        }).map(this::convert).toList();
    }

    @Override
    public List<VehicleAllDto> listAllVehiclesByPrice(int since, int to) {
        final int too = to == 0 ? Integer.MAX_VALUE : to;
        return vehicleRepository.listAll().stream().filter(v -> {
            Long price = v.getPrice();
            return price >= since && price <= too;
        }).map(this::convert).toList();
    }

    @Override
    public VehicleIdDto listAllVehiclesById(int id) {
        Vehicle vehicle = vehicleRepository.listAll().stream().filter(v -> v.getId().equals(id)).findFirst().orElse(null);
        if (vehicle == null) {
            return null;
        }

        VehicleIdDto vehicleDto = new VehicleIdDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setDoors(vehicle.getDoors());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setPrice(vehicle.getPrice());
        vehicleDto.setDate(vehicle.getEntryDate());
        vehicleDto.setMileage(vehicle.getMileage());

        vehicleDto.setServices(vehicle.getServiceModels().stream().map(s -> {
            ServiceVehiclesIdDto serviceDto = new ServiceVehiclesIdDto();
            serviceDto.setId(s.getId());
            serviceDto.setDate(s.getDate());
            serviceDto.setDescriptions(s.getDescriptions());
            serviceDto.setMileage(s.getMileage());

            return serviceDto;
        }).toList());

        return vehicleDto;
    }
}
