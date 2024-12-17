package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.Request.RequestCreateVehicleDTO;
import com.bootcampW22.EjercicioGlobal.dto.Request.RequestUpdateFuelDTO;
import com.bootcampW22.EjercicioGlobal.dto.Request.RequestUpdateSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.Response.AveragePassengersByBrand;
import com.bootcampW22.EjercicioGlobal.dto.Response.AverageSpeedByBrandDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.InvalidBodyArgumentsException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.OutOfRangeException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;
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
    public String addNewVehicle(RequestCreateVehicleDTO vehicleDTO) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();

        Vehicle vehicleToAdd = new Vehicle();

        vehicleToAdd.setId(vehicleDTO.getId());
        vehicleToAdd.setBrand(vehicleDTO.getBrand());
        vehicleToAdd.setModel(vehicleDTO.getModel());
        vehicleToAdd.setRegistration(vehicleDTO.getRegistration());
        vehicleToAdd.setColor(vehicleDTO.getColor());
        vehicleToAdd.setYear(vehicleDTO.getYear());
        vehicleToAdd.setMax_speed(vehicleDTO.getMax_speed());
        vehicleToAdd.setPassengers(vehicleDTO.getPassengers());
        vehicleToAdd.setFuel_type(vehicleDTO.getFuel_type());
        vehicleToAdd.setTransmission(vehicleDTO.getTransmission());
        vehicleToAdd.setHeight(vehicleDTO.getHeight());
        vehicleToAdd.setWeight(vehicleDTO.getWeight());
        vehicleToAdd.setWidth(vehicleDTO.getWidth());

        if(vehicleList.stream().anyMatch(v -> v.getId().equals(vehicleToAdd.getId()))){
            throw new VehicleAlreadyExistsException("Identificador del vehículo ya existente");
        }

        vehicleList.add(vehicleToAdd);
        return "Vehículo creado exitosamente";
    }

    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();

        List<Vehicle> filteredVehicles = vehicleList
                .stream()
                .filter(v -> v.getColor().equals(color) && v.getYear() == year)
                .collect(Collectors.toList());

        if(filteredVehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return filteredVehicles
                .stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehicleDto> findByBrandAndYears(String brand, int start_year, int end_date) {

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteredList = vehicleList
                .stream()
                .filter(v -> v.getBrand().equals(brand) && (v.getYear() >= start_year && v.getYear() <= end_date))
                .collect(Collectors.toList());

        if(filteredList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }

        return filteredList.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).collect(Collectors.toList());

    }

    public AverageSpeedByBrandDTO averageSpeedByBrand(String brand) {

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteredVehicle = vehicleList
                .stream()
                .filter(v -> v.getBrand().equals(brand))
                .collect(Collectors.toList());

        if(filteredVehicle.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        double averageSpeed = filteredVehicle.stream()
                .mapToDouble(Vehicle::getMax_speed).average().orElse(Double.NaN);

        AverageSpeedByBrandDTO response = new AverageSpeedByBrandDTO();
        response.setBrand(brand);
        response.setAverageSpeed(averageSpeed);

        return response;

    }

    @Override
    public String createMultipleVehicles(List<RequestCreateVehicleDTO> vehicles) {

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        for (RequestCreateVehicleDTO v: vehicles){
            if(v.getId() == null || v.getBrand() == null || v.getModel() == null || v.getRegistration() == null ||
            v.getColor() == null || v.getYear() == null || v.getMax_speed() == null || v.getPassengers() == null ||
            v.getFuel_type() == null || v.getTransmission() == null || v.getHeight() == null || v.getWeight() == null ||
            v.getWidth() == null){
                throw new InvalidBodyArgumentsException("Datos de algún vehículo mal formados o incompletos");
            }

            if(vehicleList.stream().anyMatch(vhc -> vhc.getId().equals(v.getId()))){
                throw new VehicleAlreadyExistsException("Algún vehículo tiene un identificador ya existente");
            }

            vehicleList.add(mapper.convertValue(v, Vehicle.class));
        }

        return "Vehículos creados exitosamente";
    }

    @Override
    public String updateMaxSpeed(Long id, RequestUpdateSpeedDTO speed) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();

        if(speed.getSpeed() <= 0){
            throw new OutOfRangeException("La velocidad máxima no puede ser menor o igual a 0");
        }

        Optional<Vehicle> vehicleToUpdate = vehicleList
                .stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();

        if(!vehicleToUpdate.isPresent()){
            throw new NotFoundException("No se encontró el vehículo");
        }

        Vehicle vehicle = vehicleToUpdate.get();
        vehicle.setMax_speed(speed.getSpeed());

        return "Velocidad del vehículo actualizada exitosamente";
    }

    @Override
    public List<VehicleDto> getVehiclesByFuelType(String type) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();

        List<Vehicle> filteresVehicles = vehicleList
                .stream()
                .filter(vehicle -> vehicle.getFuel_type().equals(type))
                .collect(Collectors.toList());

        if(filteresVehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible");
        }

        return filteresVehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteVehicle(Long id){

        List<Vehicle> vehicleList = vehicleRepository.findAll();

        Optional<Vehicle> optionalVehicle = vehicleList
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst();

        if(!optionalVehicle.isPresent()){
            throw new NotFoundException("No se encontró el vehículo");
        }

        Vehicle vehicleToDelete = optionalVehicle.get();
        vehicleList.remove(vehicleToDelete);

        return "Vehículo eliminado exitosamente";

    }

    @Override
    public List<VehicleDto> getVehiclesByTransmission(String type) {

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteredVehicles = vehicleList
                .stream()
                .filter(vehicle -> vehicle.getTransmission().equals(type))
                .collect(Collectors.toList());

        if(filteredVehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }

        return filteredVehicles
                .stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public String updateFuel(Long id, RequestUpdateFuelDTO fuel) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();

        Optional<Vehicle> optionalVehicle = vehicleList
                .stream()
                .filter(vehicle -> vehicle.getId().equals(id))
                .findFirst();

        if(!optionalVehicle.isPresent()){
            throw new NotFoundException("No se encontró el vehículo");
        }

        Vehicle vehicleToUpdate = optionalVehicle.get();
        vehicleToUpdate.setFuel_type(fuel.getFuel());

        return "Tipo de combustible del vehículo actualizado exitosamente";
    }

    @Override
    public AveragePassengersByBrand getAveragePassengersByBrand(String brand) {

        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteredVehicles = vehicleList
                .stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .collect(Collectors.toList());

        if(filteredVehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }

        double average = filteredVehicles.stream().mapToDouble(Vehicle::getPassengers).average().orElse(Double.NaN);

        AveragePassengersByBrand response = new AveragePassengersByBrand();
        response.setBrand(brand);
        response.setAverage(average);

        return response;

    }
}
