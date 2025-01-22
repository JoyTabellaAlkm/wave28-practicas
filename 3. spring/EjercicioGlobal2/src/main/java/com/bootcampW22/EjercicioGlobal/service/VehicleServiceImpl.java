package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.SpeedAvergeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleCreateDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.DuplicateVehicleException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.CResourceUtils;
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
    public void addVehicle(VehicleDto vehicleDto) {

        //Validacion de mensaje 400 datos mal formados o incompletos
        if (
                vehicleDto.getId() == null ||
                        vehicleDto.getBrand() == null || vehicleDto.getBrand().isEmpty() ||
                        vehicleDto.getModel() == null || vehicleDto.getModel().isEmpty() ||
                        vehicleDto.getRegistration() == null || vehicleDto.getRegistration().isEmpty() ||
                        vehicleDto.getColor() == null || vehicleDto.getColor().isEmpty() ||
                        vehicleDto.getYear() <= 0 ||
                        vehicleDto.getMax_speed() == null || vehicleDto.getMax_speed().isEmpty() ||
                        vehicleDto.getPassengers() <= 0 ||
                        vehicleDto.getFuel_type() == null || vehicleDto.getFuel_type().isEmpty() ||
                        vehicleDto.getTransmission() == null || vehicleDto.getTransmission().isEmpty() ||
                        vehicleDto.getHeight() <= 0 ||
                        vehicleDto.getWidth() <= 0 ||
                        vehicleDto.getWeight() <= 0
        ) {
            throw new BadRequestException("Datos del vehículo mal formados o incompletos.");
        }

        ObjectMapper mapper = new ObjectMapper();
        Vehicle newVehicle = mapper.convertValue(vehicleDto, Vehicle.class);

        // Validación de duplicado
        boolean exists = vehicleRepository.findAll()
                .stream()
                .anyMatch(v -> v.getId().equals(newVehicle.getId()));

        if (exists) {
            throw new DuplicateVehicleException("El vehículo con el ID " + newVehicle.getId() + " ya existe.");
        }

        vehicleRepository.addVehicle(newVehicle);
    }

    //Ejercicio 2
    public List<VehicleDto> findVehiculoWithColorYear (String color, int year){
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                .filter(o -> o.getColor().equalsIgnoreCase(color) && o.getYear() == year)
                .collect(Collectors.toList());
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con esos criterios");
        }
        return vehicles.stream().map(o -> CResourceUtils.MAPPER.convertValue(o, VehicleDto.class))
                .collect(Collectors.toList());
    }

    public List<VehicleDto> findVehiculoWithBrandYears (String brand, int start_year, int end_year){
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand) && v.getYear() >= start_year && v.getYear() <= end_year)
                .collect(Collectors.toList());
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con esos criterios");
        }
        return vehicles.stream().map(v -> CResourceUtils.MAPPER.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    public SpeedAvergeDto averageSpeedWithBrand (String brand){
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());

        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con esos criterios");
        }
        double speedAverage = vehicles.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0.0);

        return new  SpeedAvergeDto(brand, speedAverage);
    }
}
