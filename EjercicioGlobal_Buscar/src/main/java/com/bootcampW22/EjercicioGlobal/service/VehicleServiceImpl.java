package com.bootcampW22.EjercicioGlobal.service;

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
public class
VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }
 //Ejercicio 2: Buscar vehículos por color y año
    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color) && v.getYear() == year)
                .toList();
        if (filteredVehicles.isEmpty())
            throw new NotFoundException("No se encontaron vehiculos del color" + color + "y el año" + year);

        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());

    }
 //Ejercicio 9: Buscar vehículos por tipo de transmisión
    @Override
    public List<VehicleDto> findByTypeTransmission(String transmission) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehiclelist = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = vehiclelist.stream()
                .filter(v -> v.getTransmission().equalsIgnoreCase(transmission))
                .toList();
        if (filteredVehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos del tipo de transmision" + transmission + "buscada");
        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

//Ejercicio 3: Buscar vehículos por marca y rango de años
    @Override
    public List<VehicleDto> findByBrandAndYear(String brand, int start_year, int end_year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand) && (v.getYear() >= start_year && v.getYear() <= end_year))
                .toList();
        if (filteredVehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos de la marca" + brand + "entre el año de fabricacion " + start_year + "el año de fabricacion" + end_year);
        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());


    }

}
