package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final IVehicleRepository vehicleRepository;
    ObjectMapper mapper = new ObjectMapper();

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchVehiclesForColorAndYear(String color, int year) {
        List<VehicleDto> vehicles = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year)
                .map( vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .collect(Collectors.toList());

        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return vehicles;
    }
}
