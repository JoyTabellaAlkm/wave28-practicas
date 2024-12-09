package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper objectMapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, ObjectMapper objectMapper){
        this.vehicleRepository = vehicleRepository;
        this.objectMapper = objectMapper;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No hay vehículos en la concesionaria.");
        }
        return vehicleList.stream()
                .map(v -> objectMapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByColorAndYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color) && v.getYear() == year)
                .toList();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream().map(v -> objectMapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> searchAllVehiclesByBrandBetweenYears(String brand, int startYear, int endYear) {
        List<Vehicle> vehicleList = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand) &&
                        v.getYear() >= startYear &&
                        v.getYear() <= endYear)
                .toList();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream().map(v -> objectMapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public AverageSpeedDto findAverageSpeedOfBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        double avgSpeed = vehicleList
                .stream()
                .mapToDouble(Vehicle::getMax_speed).average()
                .orElse(0);
        return new AverageSpeedDto(brand, avgSpeed);
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        Vehicle newVehicle = objectMapper.convertValue(vehicleDto, Vehicle.class);
        vehicleRepository.save(newVehicle);
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> createVehicleBatch(List<VehicleDto> vehicleDtoList) {
         List<Vehicle> newVehiclesList = vehicleDtoList
                 .stream()
                 .map(v -> objectMapper.convertValue(v, Vehicle.class))
                 .toList();
         List<Long> createdVehiclesIds = new ArrayList<>();
         newVehiclesList.forEach(v -> {
             try {
                vehicleRepository.save(v);
             } catch (VehicleAlreadyExistsException e) {
                 StringBuilder sb = new StringBuilder();
                 createdVehiclesIds.forEach(id -> {
                     sb.append(id).append(" ");
                 });
                 throw new VehicleAlreadyExistsException("No se pudo ejecutar el batch completamente." +
                         " Sin embargo se crearon los ids: " + sb.toString());
             }
             createdVehiclesIds.add(v.getId());
         });
         return vehicleDtoList;
    }
}
