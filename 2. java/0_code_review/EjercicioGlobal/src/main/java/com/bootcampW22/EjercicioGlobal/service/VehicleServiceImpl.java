package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> objectMapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String saveVehicle(Vehicle vehicle) throws IOException {

        try {
            System.out.println(vehicle);

            if (vehicle.getId() == null) {
                throw new BadRequestException("El Id no puede ser nulo");
            }

        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        // TODO: Validar estrucutra del objeto.


        List<VehicleDto> vehicleList = searchAllVehicles();
        long result =
                vehicleList.stream()
                        .filter(vehicleDto -> vehicleDto.getId().equals(vehicle.getId()))
                        .count();

        if (result > 0) {
            throw new AlreadyExistsException("Identificador del vehículo ya existe");
        }
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<VehicleDto> findVehiclesByColorAndYear(String color, Integer year) {
        // Ejercicio 2
        List<VehicleDto> vehicleList = searchAllVehicles();
        List<VehicleDto> vehicleFound = vehicleList.stream()
                .filter(vehicleDto -> vehicleDto.getColor().equalsIgnoreCase(color))
                .filter(vehicleDto -> vehicleDto.getYear() == year)
                .toList();

        if (vehicleFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehicleFound;
    }

    @Override
    public List<VehicleDto> findVehiclesByBrandAndYears(String brand, Integer startYear, Integer endYear) {
        // Ejercicio 3
        List<VehicleDto> vehicleList = searchAllVehicles();
        List<VehicleDto> vehiclesFound = vehicleList.stream()
                .filter(vehicleDto -> vehicleDto.getBrand().equalsIgnoreCase(brand))
                .filter(vehicleDto -> vehicleDto.getYear() >= startYear && vehicleDto.getYear() <= endYear)
                .toList();

        if (vehiclesFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios ");
        }

        return vehiclesFound;
    }

    @Override
    public Double averageSpeedByBrand(String brand) {
        // Ejercicio 4

        List<VehicleDto> vehicleList = searchAllVehicles();

        List<VehicleDto> vehiclesFound = vehicleList.stream()
                .filter(vehicleDto -> vehicleDto.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos de esa marca");
        }


        return vehiclesFound.stream()
                .mapToDouble(vehicleDTO -> Double.parseDouble(vehicleDTO.getMax_speed()))
                .average()
                .orElse(0.0);
    }

    @Override
    public String saveVehiclesBatch(List<Vehicle> vehicleList) {

        List<VehicleDto> vehicleListDto = searchAllVehicles();

        vehicleList.forEach(
                vehicle -> {
                    boolean vehicleFound =
                            vehicleListDto.stream().anyMatch(vehicleDto -> vehicleDto.getId().equals(vehicle.getId()));
                    if (vehicleFound) {
                        throw new AlreadyExistsException("Algún vehículo tiene un identificador ya existente");
                    }
                });

        vehicleList.forEach(vehicle -> {
            try {
                vehicleRepository.save(vehicle);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return "Vehículos creados exitosamente";
    }

    @Override
    public String updateSpeed(Long id, String speed) {
        List<VehicleDto> vehicleList = searchAllVehicles();

        List<VehicleDto> vehicleFound = vehicleList.stream().filter(vehicle -> vehicle.getId().equals(id)).toList();

        if (vehicleFound.isEmpty()) {
            throw new NotFoundException("No se encontró el vehículo.");
        }

        vehicleList.stream()
                .filter(vehicleDto -> vehicleDto.getId().equals(id))
                .findFirst().ifPresent(vehicleDto -> vehicleDto.setMax_speed(speed));

        List<Vehicle> vehicleListUpdate = vehicleList.stream()
                .map(vehicleDto -> objectMapper.convertValue(vehicleDto, Vehicle.class))
                .toList();

        vehicleRepository.update(vehicleListUpdate);

        return "Velocidad del vehículo actualizada exitosamente.";
    }

    @Override
    public List<VehicleDto> findVehicleByFuel(String fuel) {
        List<VehicleDto> vehicleDtoList = searchAllVehicles();

        List<VehicleDto> vehiclesFound =
                vehicleDtoList.stream()
                        .filter(vehicleDto -> vehicleDto.getFuel_type().equalsIgnoreCase(fuel))
                        .toList();

        if (vehiclesFound.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehiclesFound;
    }

    @Override
    public String deleteVehicle(Long id) {

        //Ejercicio 8
        List<VehicleDto> vehicleDtoList = searchAllVehicles();;

        List<VehicleDto> vehicleFound =
                vehicleDtoList.stream()
                        .filter(vehicleDto -> vehicleDto.getId().equals(id))
                        .toList();

        if (vehicleFound.isEmpty()) {
            throw new NotFoundException("No se encontró el vehículo.");
        }

        vehicleDtoList.removeAll(vehicleFound);

        List<Vehicle> vehicleListUpdate = vehicleDtoList.stream().map(vehicleDto -> objectMapper.convertValue(vehicleDto,
                Vehicle.class)).toList();

        vehicleRepository.update(vehicleListUpdate);

        return "Vehículo eliminado exitosamente.";
    }

    @Override
    public List<VehicleDto> findVehiclesByTransmission(String transmission) {

        List<VehicleDto> vehicleDtoList = searchAllVehicles();
        List<VehicleDto> vehiclesFound = vehicleDtoList.stream()
                .filter(vehicleDto -> vehicleDto.getTransmission().equalsIgnoreCase(transmission))
                .toList();

        if(vehiclesFound.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }

        return vehiclesFound;
    }

    @Override
    public String updateFuel(Long id, String fuel) {

        List<VehicleDto> vehicleDtoList = searchAllVehicles();
        Optional<VehicleDto> vehicleFound = vehicleDtoList.stream()
                .filter(vehicleDto -> vehicleDto.getId().equals(id))
                .findFirst();

        if (vehicleFound.isEmpty()){
            throw new NotFoundException("No se encontró el vehículo");
        }

        vehicleDtoList.stream()
                .filter(vehicleDto -> vehicleDto.getId().equals(id))
                .findFirst().ifPresent(vehicleDto -> vehicleDto.setFuel_type(fuel));

        List<Vehicle> vehicleListUpdate = vehicleDtoList.stream()
                .map(vehicleDto -> objectMapper.convertValue(vehicleDto, Vehicle.class))
                .toList();

        vehicleRepository.update(vehicleListUpdate);

        return "Tipo de combustible del vehiculo actualizado exitosamente";
    }

    @Override
    public Double averageCapacityByBrand(String brand) {

        List<VehicleDto> vehicleDtoList = searchAllVehicles();

        List<VehicleDto> vehiclesFound = vehicleDtoList.stream()
                .filter(vehicleDto -> vehicleDto.getBrand().equalsIgnoreCase(brand)).toList();

        if (vehiclesFound.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        return vehiclesFound.stream()
                .mapToDouble(VehicleDto::getPassengers)
                .average()
                .orElse(1.0);
    }

    @Override
    public List<VehicleDto> findVehiclesByDimension(Double minLength, Double maxLength, Double minWidth, Double maxWidth) {

        List<VehicleDto> vehicleDtoList = searchAllVehicles();

        List<VehicleDto> vehiclesFound =
                vehicleDtoList.stream()
                        .filter(vehicleDto -> (vehicleDto.getHeight() >= minLength && vehicleDto.getHeight() <= maxLength))
                        .filter(vehicleDto -> (vehicleDto.getWidth() >= minWidth && vehicleDto.getWidth() <= maxWidth))
                        .toList();

        if (vehiclesFound.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con esas dimensiones");
        }

        return vehiclesFound;
    }

    @Override
    public List<VehicleDto> findVehiclesByWeight(Double minWeight, Double maxWeight) {
        List<VehicleDto> vehicleDtoList = searchAllVehicles();
        List<VehicleDto> vehicleFound = vehicleDtoList.stream()
                .filter(vehicleDto -> vehicleDto.getWeight() >= minWeight && vehicleDto.getWeight() <= maxWeight)
                .toList();

        if(vehicleFound.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos en ese rango de peso");
        }

        return vehicleFound;
    }


}