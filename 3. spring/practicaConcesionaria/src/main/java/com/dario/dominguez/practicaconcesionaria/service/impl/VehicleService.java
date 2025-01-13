package com.dario.dominguez.practicaconcesionaria.service.impl;

import com.dario.dominguez.practicaconcesionaria.dto.VehicleDto;
import com.dario.dominguez.practicaconcesionaria.entity.Vehicle;
import com.dario.dominguez.practicaconcesionaria.repository.IVehicleRepository;
import com.dario.dominguez.practicaconcesionaria.service.IVehicleService;
import com.dario.dominguez.practicaconcesionaria.entity.VService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    IVehicleRepository repository;

    ModelMapper modelMapper = new ModelMapper();


    @Override
    public Vehicle addVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        System.out.println(vehicleDto.getManufacturingDate());

        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setManufacturingDate(vehicleDto.getManufacturingDate());
        vehicle.setNumberOfKilometers(vehicleDto.getNumberOfKilometers());
        vehicle.setDoors(vehicleDto.getDoors());
        vehicle.setPrice(vehicleDto.getPrice());
        vehicle.setCurrency(vehicleDto.getCurrency());
        vehicle.setServices(vehicleDto.getServices().stream().map(s -> modelMapper.map(s, VService.class)).toList());

        return repository.save(vehicle);
    }

    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> allVehicles = repository.findAll();
        return allVehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    public List<VehicleDto> getSinceTo(String since, String to) {
        List<Vehicle> allVehicles = repository.findAll();

        // Convertir los parámetros de año a enteros
        int sinceYear = Integer.parseInt(since);
        int toYear = Integer.parseInt(to);

        System.out.println(sinceYear);
        System.out.println(toYear);

        return allVehicles.stream()
                .filter(vehicle -> {
            int vehicleYear = vehicle.getManufacturingDate().getYear() + 1900;
            return vehicleYear >= sinceYear && vehicleYear <= toYear;
        })
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .collect(Collectors.toList());

    }
}
