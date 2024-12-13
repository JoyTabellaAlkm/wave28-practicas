package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlredyExists;
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
    public List<VehicleDto> crearVehiculos(List<Vehicle> vehiculos) {
        for (Vehicle vehiculo: vehiculos){
            if(vehicleRepository.findByID(vehiculo.getId()) != null){
                throw new VehicleAlredyExists("Algún vehículo tiene un identificador ya existente");
            }
            if(vehiculo.getBrand() == null || vehiculo.getModel() == null) {
                throw new BadRequest("Datos de algún vehículo mal formados o incompletos");
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return vehicleRepository.crearVehiculos(vehiculos).stream()
                .map(entry -> mapper.convertValue(entry, VehicleDto.class))
                .collect(Collectors.toList());
    }
}
