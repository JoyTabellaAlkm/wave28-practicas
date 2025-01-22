package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final ApplicationEventPublisher applicationEventPublisher;
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, ApplicationEventPublisher applicationEventPublisher){
        this.vehicleRepository = vehicleRepository;
        this.applicationEventPublisher = applicationEventPublisher;
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
    public  double getVehiculo(String brand){
        List<Vehicle> vehiclesList = vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());

        if (vehiclesList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }


        double totalSpeed = vehiclesList.stream()
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed())).sum();
        return totalSpeed / vehiclesList.size();
    }
}
