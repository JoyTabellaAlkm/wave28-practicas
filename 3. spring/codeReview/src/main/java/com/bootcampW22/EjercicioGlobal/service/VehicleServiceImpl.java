package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicle){
        List<VehicleDto> vehicles = this.searchAllVehicles();
        boolean yaExiste = vehicles.stream().anyMatch(v -> v.getId() == vehicle.getId());
        if (yaExiste) {
            throw new ConflictException(" Identificador del vehículo ya existente.");
        }

        ObjectMapper mapper = new ObjectMapper();
        Vehicle new_vehicle = mapper.convertValue(vehicle, Vehicle.class);
        vehicleRepository.addVehicle(new_vehicle);
        return vehicle;
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, String year) {
        List<VehicleDto> vehicles = this.searchAllVehicles();
        List<VehicleDto> result =  vehicles.stream().filter(
                vehicle -> vehicle.getColor().equals(color) &&
                        vehicle.getYear() == Integer.parseInt(year))
                .toList();
        if (result.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return result;
    }

    @Override
    public VehicleDto updateSpeed(String id, String newSpeed) {
        List<VehicleDto> vehicles = this.searchAllVehicles();
        vehicles = vehicles.stream()
                .filter(vehicleDto -> vehicleDto.getId() == Integer.parseInt(id))
                .toList();

        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = mapper.convertValue(vehicles.get(0), Vehicle.class);
        vehicle.setMax_speed(newSpeed);
        vehicleRepository.updateVehicle(vehicle);

        return this.searchAllVehicles().stream().filter(vehicleDto -> vehicleDto.getId() == Integer.parseInt(id)).toList().get(0);
    }

    @Override
    public List<VehicleDto> listByWeightRange(Double min, Double max) {
        List<VehicleDto> vehicles = this.searchAllVehicles();

        return vehicles.stream().filter(vehicle -> vehicle.getWeight() > min && vehicle.getWeight() < max).toList();
    }
}
