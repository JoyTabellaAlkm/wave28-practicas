package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    public VehicleDto postAVehicle(VehicleDto vehicle) {
//        if(vehicleRepository.exists(vehicle)){
//            throw new ConflictException("409 Conflict: Identificador del vehículo ya existente.");
//        }
        ObjectMapper mapper = new ObjectMapper();

        Vehicle vehicleNew = mapper.convertValue(vehicle, Vehicle.class);

        return mapper.convertValue(vehicleRepository.postVehicle(vehicleNew), VehicleDto.class);

    }

    @Override
    public List<VehicleDto> searchVehiclesByDimensions(String length, String width) {
        String[] lengthParts = length.split("-");
        String[] widthParts = width.split("-");

        ObjectMapper mapper = new ObjectMapper();

        int minLength = Integer.parseInt(lengthParts[0]);
        int maxLength = Integer.parseInt(lengthParts[1]);
        int minWidth = Integer.parseInt(widthParts[0]);
        int maxWidth = Integer.parseInt(widthParts[1]);

        List<Vehicle> listVehicleWithDimensions = vehicleRepository.getVehiclesByDimensions(minLength,maxLength,minWidth,maxWidth);

        if(listVehicleWithDimensions.isEmpty())
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");

        return  listVehicleWithDimensions.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public Double averageCapacity(String brand) {
        List<Vehicle> vehiclesForBrand = vehicleRepository.vehiclesForBrand(brand);
        int count = 0;
        double average = vehiclesForBrand.stream()
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0.0);

        return average ;
    }




}
