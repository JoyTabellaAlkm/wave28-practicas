package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AvarageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AvarageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
//Ejercicio7 :Listar vehículos por tipo de combustible
    @Override
    public List<VehicleDto> findByFuelType(String fuelType) {
        ObjectMapper mapper = new ObjectMapper();

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro listado de vehiculos");
        }
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getFuel_type().equalsIgnoreCase(fuelType))
                .toList();

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }
 //Ejercicio 13: Listar vehículos por rango de peso
    @Override
    public List<VehicleDto> findByWeightRange (double min, double max){
        ObjectMapper mapper = new ObjectMapper();
        List <Vehicle> vehicleList=vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro listado de vehiculos");
        }
        List<Vehicle> filteredVehicles=vehicleList.stream()
                .filter(v-> v.getWeight()>=min && v.getWeight() <= max)
                .toList();
          if(filteredVehicles.isEmpty()){
              throw new NotFoundException (" No se encontraron vehiculos en ese rango");

          }
          return filteredVehicles.stream()
                  .map(v->mapper.convertValue(v,VehicleDto.class))
                  .collect(Collectors.toList());
    }

    //Ejercicio 11: Obtener la capacidad promedio de personas por marca
    public AvarageCapacityDto calculateAverageCapacityByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro listado de vehiculos");
        }
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();
        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con la marca" + brand+  "ingresada");
        }

        double averageCapacity = filteredVehicles.stream()
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0);

        return new AvarageCapacityDto(brand, averageCapacity);
    }

  //Ejercicio 4: Consultar velocidad promedio por marca
    public AvarageSpeedDto calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontro listado de vehiculos");
        }
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con la marca" + brand +  "ingresada");
        }

        double averageSpeed = filteredVehicles.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0);

        return new AvarageSpeedDto(brand, averageSpeed);
    }






}



