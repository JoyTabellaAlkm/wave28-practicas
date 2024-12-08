package com.mercadolibre.concesionariaautos.service.impl;

import com.mercadolibre.concesionariaautos.dto.PartialVehicleDTO;
import com.mercadolibre.concesionariaautos.dto.ServiceDTO;
import com.mercadolibre.concesionariaautos.dto.VehicleDTO;
import com.mercadolibre.concesionariaautos.model.Service;
import com.mercadolibre.concesionariaautos.model.Vehicle;
import com.mercadolibre.concesionariaautos.repository.IVehicleRepository;
import com.mercadolibre.concesionariaautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class VehicleService implements IVehicleService {

    @Autowired
    private IVehicleRepository vehicleRepository;

    @Override
    public String create(VehicleDTO dto) {

        try{
            Vehicle vehicle = new Vehicle();
            populate(vehicle, dto);
            vehicleRepository.create(vehicle);
            return "Vehiculo creado satisfactoriamente";

        } catch(Exception e) {
            return "Error al crear el vehiculo: " + e.getMessage();
        }
    }

    @Override
    public List<PartialVehicleDTO> getAll() {
        List<Vehicle> vehicles = vehicleRepository.getAll();
        return vehicles.stream().map(v -> PartialVehicleDTO.fromEntity(v)).toList();
    }

    @Override
    public List<PartialVehicleDTO> getVehiclesBetweenDates(LocalDate since, LocalDate to) {
        List<Vehicle> vehicles = vehicleRepository
                .getAll().stream()
                .filter(v -> v.getManufacturingDate().isAfter(since) && v.getManufacturingDate().isBefore(to))
                .toList();
        return vehicles.stream().map(v -> PartialVehicleDTO.fromEntity(v)).toList();
    }

    @Override
    public List<PartialVehicleDTO> getVehiclesBetweenPrices(Double since, Double to) {
        List<Vehicle> vehicles = vehicleRepository
                .getAll().stream()
                .filter(v -> v.getPrice() >= since && v.getPrice() <= to).toList();
        return vehicles.stream().map(v -> PartialVehicleDTO.fromEntity(v)).toList();
    }

    @Override
    public VehicleDTO getVehiclesById(Integer id) {
        List<Vehicle> vehicles = vehicleRepository.getAll();
        Optional<Vehicle> vehicle = vehicles.stream().filter(v -> v.getId().equals(id)).findFirst();
        return vehicle.map(VehicleDTO::fromEntity).orElse(null);
    }

    public void populate(Vehicle vehicle, VehicleDTO dto) {
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setManufacturingDate(dto.getManufacturingDate());
        vehicle.setNumberOfKilometers(dto.getNumberOfKilometers());
        vehicle.setDoors(dto.getDoors());
        vehicle.setPrice(dto.getPrice());
        vehicle.setCurrency(dto.getCurrency());
        if(!dto.getServices().isEmpty()) {
            List<Service> services = dto.getServices().stream().map(s -> {
                Service service = new Service();
                populateService(service,s);
                return service;
            }).toList();

            vehicle.setServices(services);
        }
        vehicle.setNumberOfOwners(dto.getNumberOfOwners());
    }

    public void populateService(Service service, ServiceDTO dto) {
        service.setDate(dto.getDate());
        service.setKilometers(dto.getKilometers());
        service.setDescriptions(dto.getDescriptions());
    }
}
