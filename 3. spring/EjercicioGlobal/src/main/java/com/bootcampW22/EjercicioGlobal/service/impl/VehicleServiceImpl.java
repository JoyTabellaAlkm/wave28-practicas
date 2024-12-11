package com.bootcampW22.EjercicioGlobal.service.impl;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ExistingDataException;
import com.bootcampW22.EjercicioGlobal.exception.InvalidDataException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.impl.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
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
    public String createVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> idPresent = vehicleRepository.findId(vehicleDto.getId());
        if(idPresent.isPresent()){
            throw new ExistingDataException("Identificador del vehiculo ya existente");
        }
        if(vehicleDto.getBrand().isEmpty() || vehicleDto.getColor().isEmpty()){
            throw new InvalidDataException("Datos del vehiculo mal formados o incompletos");
        }

        Vehicle vehicle = mapper.convertValue(vehicleDto,Vehicle.class);
        return vehicleRepository.addVehicle(vehicle);
    }
}