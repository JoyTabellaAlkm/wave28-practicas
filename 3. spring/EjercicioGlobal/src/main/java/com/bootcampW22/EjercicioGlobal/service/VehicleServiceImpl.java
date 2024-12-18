package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleConflictException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleConflictExceptionn;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

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
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    public VehicleDto addVehicle(VehicleDto vehicleDto) {

        if (vehicleDto.getId() == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }

        Vehicle vehicle = vehicleRepository.findById(vehicleDto.getId());
        if (vehicle != null) {
            throw new VehicleConflictException("El vehículo con ID " + vehicleDto.getId() + " ya existe.");
        }

        ObjectMapper mapper = new ObjectMapper();
        Vehicle newVehicle = mapper.convertValue(vehicleDto, Vehicle.class);

        vehicleRepository.add(newVehicle);

        return mapper.convertValue(newVehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> searchVehiclesByColorAndYear(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findVehicleByColorAndYear(color, year);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> searchVehiclesByBrandAndYearRange(String brand, int startYear, int endYear) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findVehicleByBrandAndYearRange(brand, startYear, endYear);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public double getAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findVehiclesByBrand(brand);
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicleList.stream()
                .mapToDouble(Vehicle::getMaxSpeedAsDouble).average().orElse(0.0);
    }

   /* @Override
    public List<VehicleDto> addVehicleBatch(List<VehicleDto> vehiclesDto) {
        ObjectMapper mapper = new ObjectMapper();


        List<Vehicle> newVehicles = vehiclesDto.stream()
                .map(vehicle -> mapper.convertValue(vehicle, Vehicle.class))
                .toList();

        for (Vehicle vehicle : newVehicles) {
            if (vehicleRepository.vehicleExists(vehicle))
                throw new VehicleConflictException("El vehiculo con ID: " + vehicle.getId() + " ya existe en la lista");
        }

       vehicleRepository.addAll(newVehicles);

        return vehiclesDto.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    */

    public VehicleDto updateVehicleSpeed(Long id, double newSpeed) {

        ObjectMapper mapper = new ObjectMapper();

        if (newSpeed < 0)
            throw new IllegalArgumentException("La velocidad no puede ser negativa.");

        Vehicle vehicle = vehicleRepository.findById(id);
        
        if (vehicle == null)
            throw new NotFoundException("No se encontró el vehículo con id " + id);

        vehicle.setMax_speed(String.valueOf(newSpeed));

        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getVehiclesByFuelType(String type) {
        ObjectMapper mapper = new ObjectMapper();

        List<Vehicle> vehicles = vehicleRepository.findVehicleByFuelType(type);

        if (vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos con el combustible: " + type);

        return vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public boolean deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null)
            throw new NotFoundException("No se encontró el vehículo con id " + id);

        return vehicleRepository.delete(vehicle);
    }

    @Override
    public List<VehicleDto> getVehiclesByTransmission(String transmission) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.getVehiclesByTransmission(transmission);

        if (vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos con el tipo de transmision: " + transmission);

        return vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public VehicleDto updateVehicleFuel(Long id, String fuel) {
        ObjectMapper mapper = new ObjectMapper();
        Vehicle vehicle = vehicleRepository.findById(id);

        if (vehicle == null) {
            throw new NotFoundException("No existe ningun vehiculo con el id: " + id);
        }

        vehicle.setFuel_type(fuel);

        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    @Override
    public double getAverageCapacityByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findVehiclesByBrand(brand);

        if (vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos de la marca: " + brand);

        return vehicles.stream().mapToInt(Vehicle::getPassengers).average().orElse(0.0);
    }

    @Override
    public List<VehicleDto> getVehiclesByDimension(double min_length, double max_length, double min_width, double max_width) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.getVehiclesByDimension(min_length, max_length, min_width, max_width);

        if (vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehiculos de tales dimensiones");

        return vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> getVehiclesByWeight(double min_weight, double max_weight) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.getVehiclesByWeight(min_weight, max_weight);

        if (vehicles.isEmpty())
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso");

        return vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> addVehicleBatch(List<VehicleDto> vehiclesDto) {
        for (VehicleDto vehicleDto : vehiclesDto) {

            if(vehicleDto.getId() == null) {
                throw new IllegalArgumentException("El ID no puede ser nulo");
            }

            if (vehicleRepository.vehicleAlreadyExists(vehicleDto.getId())) {
                throw new VehicleConflictExceptionn("El vehiculo con ID: " + vehicleDto.getId() + "ya existe");
            }


        }

        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehiclesDto.stream().map(vehicleDto -> mapper.convertValue(vehicleDto, Vehicle.class)).toList();

        vehicleRepository.addVehicleBatch(vehicles);

        return vehicles.stream().map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class)).toList();
    }


}
