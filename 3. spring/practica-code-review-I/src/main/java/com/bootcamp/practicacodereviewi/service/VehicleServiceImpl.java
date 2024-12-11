package com.bootcamp.practicacodereviewi.service;


import com.bootcamp.practicacodereviewi.dto.VehicleDto;
import com.bootcamp.practicacodereviewi.entity.Vehicle;
import com.bootcamp.practicacodereviewi.exception.BadRequestException;
import com.bootcamp.practicacodereviewi.exception.InternalServerErrorException;
import com.bootcamp.practicacodereviewi.exception.NotFoundException;
import com.bootcamp.practicacodereviewi.exception.VehicleAlreadyExistsException;
import com.bootcamp.practicacodereviewi.repository.IVehicleRepository;
import com.bootcamp.practicacodereviewi.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto createVehicle(VehicleDto vehicleDto) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        boolean existeVehiculoConId = vehicleList.stream().anyMatch(v -> v.getId().equals(vehicleDto.getId()));
        if(existeVehiculoConId) {
            throw new VehicleAlreadyExistsException("El id ingresado ya existe para un vehiculo existente");
        }
        Vehicle vehicleCreated = vehicleRepository.createVehicle(vehicleDto);

        return  mapper.convertValue(vehicleCreated, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> searchVehiclesByColourAndYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
                    List<VehicleDto> vehiclesFilteredByColorAndYear = vehicleList.
                stream().
                filter(v -> v.getColor().equalsIgnoreCase(color) && v.getYear() == year).
                map(v -> mapper.convertValue(v, VehicleDto.class)).
                collect(Collectors.toList());

        if(vehiclesFilteredByColorAndYear.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos con el color y año ingresados");
        }

        return vehiclesFilteredByColorAndYear;
    }

    @Override
    public List<VehicleDto> searchVehiclesByBrandAndRangeOfYears(String brand, int fromYear, int toYear) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> vehiclesFiltered = vehicleList.
                stream().
                filter(v -> v.getBrand().equalsIgnoreCase(brand) && (v.getYear() >= fromYear && v.getYear() <= toYear)).
                toList();

        if(vehiclesFiltered.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos con la marca y rango de año de fabricacion ingresado");
        }

        return vehiclesFiltered.stream().map(entity -> mapper.convertValue(entity, VehicleDto.class)).toList();
    }

    @Override
    public double getAverageSpeedFromBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        List<Vehicle> vehiclesFiltered = vehicleList.
                stream().
                filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();

        if(vehiclesFiltered.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos para la marca ingresada");
        }

        double averageSpeed = vehiclesFiltered.
                stream().
                mapToDouble(v -> Double.parseDouble(v.getMax_speed())).
                average().
                getAsDouble();

        return averageSpeed;
    }

    @Override
    public List<VehicleDto> createListOfVehicles(List<VehicleDto> vehicles) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        boolean anyInsertedVehicleAlreadyExists = vehicleList.
                stream().
                anyMatch(
                existingVehicle -> vehicles.stream().anyMatch(vehicleToAdd -> vehicleToAdd.getId().equals(existingVehicle.getId()))
        );

        if (anyInsertedVehicleAlreadyExists) {
            throw new VehicleAlreadyExistsException("Alguno de los vehiculos ingresados tiene como id uno ya existente");
        }

        return vehicleRepository.createListOfVehicles(vehicles).stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> searchVehiclesByDimensions(double minWidth, double maxWidth, double minHeigth, double maxHeigth) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> vehiclesFiltered = vehicleList.stream().filter(
                v -> (v.getHeight() >= minHeigth && v.getHeight() <= maxHeigth) && (v.getWidth() >= minWidth && v.getWidth() <= maxHeigth)).
                toList();

        if(vehiclesFiltered.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos para las dimensiones ingresadas");
        }


        return vehiclesFiltered.stream().map(
                v -> mapper.convertValue(v, VehicleDto.class)
                ).toList();
    }

    @Override
    public void deleteVehicle(Long id) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        boolean existsVehicle = vehicleList.stream().anyMatch(v -> v.getId().equals(id));

        if(!existsVehicle) {
            throw new NotFoundException("El id ingresado no corresponde a un vehiculo existente");
        }

        boolean isSuccessfulDelete = vehicleRepository.deleteVehicle(id);
        if(!isSuccessfulDelete) {
            throw new InternalServerErrorException("Ocurrio un error inesperado al eliminar el vehiculo, intente nuevamente");
        }
    }

    @Override
    public VehicleDto updateVehicleMaxSpeed(Long id, String newMaxSpeed) {
        try {
            double parsedSpeed = Double.parseDouble(newMaxSpeed);
            if (parsedSpeed <= 0) {
                throw new IllegalArgumentException("Velocidad fuera de rango");
            }
        } catch (Exception e) {
            throw new BadRequestException("Velocidad mal formada o fuera de rango");
        }

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        Optional<Vehicle> existingVehicle = vehicleList.stream().filter(v -> v.getId().equals(id)).findFirst();

        if(existingVehicle.isEmpty()) {
            throw new NotFoundException("El id ingresado no corresponde a un vehiculo existente");
        }

        Vehicle updatedVehicle = existingVehicle.get();
        updatedVehicle.setMax_speed(newMaxSpeed);

        updatedVehicle = vehicleRepository.updateVehicle(id, updatedVehicle);

        return mapper.convertValue(updatedVehicle, VehicleDto.class);
    }


}
