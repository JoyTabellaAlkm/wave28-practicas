package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    private final IVehicleRepository vehicleRepository;
    private final ModelMapper modelMapper;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, ModelMapper modelMapper){
        this.vehicleRepository = vehicleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VehicleDto> findAll() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningún auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String save(VehicleDto vehicle) {
        validateExistingVehicle(vehicle.getId());
        return vehicleRepository.save(modelMapper.map(vehicle, Vehicle.class));
    }

    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = vehicleRepository.findByColorAndYear(color, year);
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findByBrandAndBetweenYear(String brand, int startYear, int endYear) {
        List<Vehicle> vehicles = vehicleRepository.findByBrandAndBetweenYear(brand, startYear, endYear);
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public Double averageSpeedByBrand(String brand) {
        OptionalDouble averageSped = vehicleRepository.averageSpeedByBrand(brand);
        if (averageSped.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        return averageSped.getAsDouble();
    }

    @Override
    public String multipleSaving(List<VehicleDto> vehicles) {

        vehicles.forEach( vehicleDto -> validateExistingVehicle(vehicleDto.getId()));

        List<Vehicle> vehiclesList = vehicles.stream()
                .map(vehicleDto -> modelMapper.map(vehicleDto, Vehicle.class))
                .toList();

        vehicleRepository.multipleSaving(vehiclesList);

        return "Vehículos creados exitosamente";
    }

    @Override
    public String updateMaxSpeed(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = findById(vehicleDto.getId());

        try {
            double value = Double.parseDouble(vehicleDto.getMax_speed());
            if( value <= 0 || value > 500){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException |
                 NullPointerException e){
            throw new BadRequestException("Velocidad mal formada o fuera de rango");
        }

        return vehicleRepository.updateMaxSpeed(vehicle, vehicleDto.getMax_speed());
    }

    @Override
    public List<VehicleDto> findByFuelType(String fuelType) {
        List<Vehicle> vehicles = vehicleRepository.findByFuelType(fuelType);
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }
        return vehicles.stream()
                .map(vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public String remove(Long id) {
        Vehicle vehicle = findById(id);
        return vehicleRepository.remove(vehicle);
    }

    @Override
    public List<VehicleDto> findByTransmissionType(String transmissionType) {
        return List.of();
    }

    @Override
    public String updateFuelType(Long id, VehicleDto vehicleDto) {
        Vehicle vehicle = findById(vehicleDto.getId());
        return vehicleRepository.updateFuelType(vehicle, vehicleDto.getFuel_type());
    }

    @Override
    public Double averageCapacityByBrand(String brand) {
        return 0.0;
    }

    @Override
    public List<VehicleDto> findByDimensions(String length, String width) {
        String[] lengths = length.split("-");
        double minLength = Double.parseDouble(lengths[0]);
        double maxLength = Double.parseDouble(lengths[1]);

        String[] widths = width.split("-");
        double minWidth = Double.parseDouble(widths[0]);
        double maxWidth = Double.parseDouble(widths[1]);

        List<Vehicle> vehicles = vehicleRepository.findByDimensions(minLength, maxLength, minWidth, maxWidth);

        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }

        return vehicles.stream()
                .map( vehicle -> modelMapper.map(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> findByWeightRange(double minWeight, double maxWeight) {
        return List.of();
    }

    public Vehicle findById(Long id){
        return vehicleRepository.findById(id).orElseThrow( () -> new NotFoundException("No se encontró el vehículo"));
    }

    public void validateExistingVehicle(Long id){
        if (vehicleRepository.findById(id).isPresent()) {
            throw new AlreadyExistsException("Identificador del vehículo ya existente: " + id);
        }
    }
}
