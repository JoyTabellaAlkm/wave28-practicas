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

    @Override
    public List<VehicleDto> findByFuelType(String fuelType) {
        ObjectMapper mapper = new ObjectMapper();

        List<Vehicle> vehicleList = vehicleRepository.findAll(); // Recupera todos los vehículos
        List<Vehicle> filteredVehicles = vehicleList.stream() // Usa Streams para filtrar
                .filter(v -> v.getFuel_type().equalsIgnoreCase(fuelType)) // Filtra por tipo de combustible
                .collect(Collectors.toList());

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class)) // Convierte a DTO
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByWeightRange (double minWeight, double maxWeight){
        ObjectMapper mapper = new ObjectMapper();
        List <Vehicle> vehicleList=vehicleRepository.findAll();
        List<Vehicle> filteredVehicles=vehicleList.stream()
                .filter(v-> v.getWeight()>=minWeight && v.getWeight() <= maxWeight)
                .toList();
          if(filteredVehicles.isEmpty()){
              throw new NotFoundException (" No se encontraron vehiculos en ese rango");

          }
          return filteredVehicles.stream()
                  .map(v->mapper.convertValue(v,VehicleDto.class))
                  .collect(Collectors.toList());
    }

    public AvarageCapacityDto calculateAverageCapacityByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll(); // Obtener todos los vehículos

        // Filtrar los vehículos por marca
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();

        // Comprobar si se encontraron vehículos de la marca
        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con la marca" + brand+  "ingresada");
        }

        // Calcular la capacidad promedio de pasajeros
        double averageCapacity = filteredVehicles.stream()
                .mapToInt(Vehicle::getPassengers) // Suponiendo que hay un método getPassengerCapacity()
                .average()
                .orElse(0);

        // Devolver el DTO con la marca y la capacidad promedio
        return new AvarageCapacityDto(brand, averageCapacity);
    }


    public AvarageSpeedDto calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll(); // Obtener todos los vehículos

        // Filtrar los vehículos por marca
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();

        // Comprobar si se encontraron vehículos de la marca
        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con la marca" + brand +  "ingresada");
        }

        // Calcular la capacidad promedio de pasajeros
        double averageSpeed = filteredVehicles.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed())) // Asegúrate de que este método devuelva un String
                .average()
                .orElse(0);  // Retorna 0 si no hay vehículos

        // Devolver el DTO con la marca y la capacidad promedio
        return new AvarageSpeedDto(brand, averageSpeed);
    }






}



