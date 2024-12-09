package com.dario.dominguez.practicaconcesionaria.service.impl;

import com.dario.dominguez.practicaconcesionaria.dto.VehicleDto;
import com.dario.dominguez.practicaconcesionaria.entity.Vehicle;
import com.dario.dominguez.practicaconcesionaria.repository.IVehicleRepository;
import com.dario.dominguez.practicaconcesionaria.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {
    @Autowired
    IVehicleRepository repository;

    ObjectMapper mapper = new ObjectMapper();

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
        vehicle.setServices(vehicleDto.getServices());

        return repository.addVehicle(vehicle);
    }

    public List<VehicleDto> getAllVehicles() {
        List<Vehicle> allVehicles = repository.getAllVehicles();
        return allVehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    public List<VehicleDto> getSinceTo(String since, String to) {
        List<Vehicle> allVehicles = repository.getAllVehicles();

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
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());

    }
}
