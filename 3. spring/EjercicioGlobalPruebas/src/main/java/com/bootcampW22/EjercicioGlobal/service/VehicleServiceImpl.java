package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ExistingVehicleException;
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

    ObjectMapper mapper;
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ObjectMapper();
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
    public Long addVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = mapper.convertValue(vehicleDto,Vehicle.class);
        if(vehicleRepository.findAll().stream().anyMatch(v->v.equals(vehicle))) throw new ExistingVehicleException("Ya existe un vehiculo con estas caracteristicas");
        return vehicleRepository.add(vehicle);
    }

    @Override
    public Double averageSpeedByBrand(String brand) {
        Double averageSpeed = vehicleRepository.findAll().stream().filter(vehicle -> vehicle.getBrand().equals(brand)).mapToDouble(vehicle->Double.valueOf(vehicle.getMax_speed())).average().orElseThrow(()->new NotFoundException("No se encontraron vehiculos de esa marca"));
        return averageSpeed;
    }

}
