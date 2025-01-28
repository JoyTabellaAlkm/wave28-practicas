package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgCapacityByBrandDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleAvgSpeedByBrandDto;
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

    VehicleRepositoryImpl vehicleRepository;

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
    public List<VehicleDto> searchVehiclesByYearAndColor(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleFilteredList = vehicleRepository.findVehiclesByYearAndColor(color,year);
        if(vehicleFilteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleFilteredList.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> searchVehiclesByBrandAndRangeOfYear(String brand, int start_year, int end_year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleFilteredList = vehicleRepository.findVehiclesByBrandAndRangeOfYear(brand,start_year,end_year);
        if(vehicleFilteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleFilteredList.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .toList();
    }

    @Override
    public VehicleAvgSpeedByBrandDto calculateAvgSpeedByBrand(String brand) {
        List<Vehicle> vehicleFilteredList = vehicleRepository.findVehiclesByBrand(brand);
        if(vehicleFilteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        double avg_speed = vehicleFilteredList.stream()
                .map(Vehicle::getMax_speed)
                .mapToDouble(Double::parseDouble)
                .average()
                .orElse(0.0);

        return new VehicleAvgSpeedByBrandDto(Math.round(avg_speed * 100.0)/100.0);
    }

    @Override
    public VehicleAvgCapacityByBrandDto calculateAvgCapacityByBrand(String brand) {
        List<Vehicle> vehicleFilteredList = vehicleRepository.findVehiclesByBrand(brand);
        if(vehicleFilteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        double avg_capacity = vehicleFilteredList.stream()
                .mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(0.0);
        return new VehicleAvgCapacityByBrandDto(Math.round(avg_capacity * 100.0)/100.0);
    }

    @Override
    public List<VehicleDto> searchVehiclesByRangeOfWeight(double weight_min, double weight_max) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleFilteredList = vehicleRepository.findVehiclesByRangeOfWeight(weight_min,weight_max);
        if(vehicleFilteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }
        return vehicleFilteredList.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .toList();
    }


}
