package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.Conflict;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final ObjectMapper objectMapper;
    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository, ObjectMapper objectMapper) {
        this.vehicleRepository = vehicleRepository;
        this.objectMapper = objectMapper;
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

    //Ejercicio 1: Añadir un vehículo
    @Override
    public ResponseMessageDto addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleDto.getBrand() == null) {
            throw new BadRequest("Datos del vehículo mal formados o incompletos.");
        }
        if (vehicleRepository.existsById(vehicleDto.getId())) {
            throw new Conflict("El identificador del vehiculo ya existe");
        }
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        vehicleRepository.save(vehicle);
        return new ResponseMessageDto("Vehiculo agregado correctamente");
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
            throw new NotFoundException("No se encontaron vehiculos del color " + color + " y el año" + year);

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
            throw new NotFoundException("No se encontraron vehiculos de la marca " + brand + " entre el año de fabricacion " + start_year + " y el año de fabricacion " + end_year);
        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());

    }

    //Ejercicio 4: Consultar velocidad promedio por marca
    public AverageSpeedDto calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();

        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con la marca " + brand + " ingresada ");
        }

        double averageSpeed = filteredVehicles.stream()
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                .average()
                .orElse(0);

        return new AverageSpeedDto(brand, averageSpeed);
    }

    // Ejercicio 5 : Añadir múltiples vehículos
    @Override
    public ResponseMessageDto addVehicles(List<VehicleDto> vehicleDtos) {
        ObjectMapper mapper = new ObjectMapper();

        for (VehicleDto vehicleDto : vehicleDtos) {
            if (vehicleDto.getBrand() == null) {
                throw new BadRequest("Datos incompletos: 'brand' es obligatorio para cada vehículo.");
            }

            if (vehicleRepository.existsById(vehicleDto.getId())) {
                throw new Conflict("Vehículo ya existente con ID: " + vehicleDto.getId());
            }
        }
        vehicleDtos.stream().map(v -> mapper.convertValue(v, Vehicle.class))
                .toList()
                .forEach(vehicleRepository::save);
        return new ResponseMessageDto("Todos los vehículos fueron creados exitosamente");

    }

    //Ejercicio 6:Actualizar velocidad máxima de un vehículo
    @Override
    public ResponseMessageDto updateMaxSpeed(Long id, MaxSpeedDto maxSpeedDto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el ID ingresado"));

        String maxSpeed1 = maxSpeedDto.getMaxSpeed();
        double maxSpeed = Double.parseDouble(maxSpeed1);
        if (maxSpeed <= 0) {
            throw new BadRequest("La velocidad mal formada");
        }
        vehicle.setMax_speed(maxSpeed1);

        vehicleRepository.save(vehicle);

        return new ResponseMessageDto("Velocidad del vehículo actualizada exitosamente");

    }

    //Ejercicio7 :Listar vehículos por tipo de combustible
    @Override
    public List<VehicleDto> findByFuelType(String fuelType) {
        ObjectMapper mapper = new ObjectMapper();

        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
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

    // Ejercicio 8 :Eliminar un vehículo
    @Override
    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("el ID ingresado " + id + " no existe")
                );
        vehicleRepository.DeleteID(vehicle);
        //return new ResponseMessageDto("vehiculo eliminado correctamente");

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
            throw new NotFoundException("No se encontraron vehiculos del tipo de transmision " + transmission + " buscada");
        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }


    // Ejercicio 10 :Actualizar el tipo de combustible de un vehículo
    @Override
    public ResponseMessageDto updateByIdFuel(Long id, FuelTypeDto fuelTypedto) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el id Ingresado"));
        String fuelType = fuelTypedto.getFuelType();
        if (!fuelType.matches("^[a-zA-Z]+$")) {
            throw new BadRequest("El tipo de combustible mal formado");
        }
        vehicle.setFuel_type(fuelType);
        vehicleRepository.save(vehicle);
        return new ResponseMessageDto("Tipo de combustible actualizado correctamente");
    }

    //Ejercicio 11: Obtener la capacidad promedio de personas por marca
    public AverageCapacityDto calculateAverageCapacityByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontro listado de vehiculos");
        }
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                .toList();
        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con la marca " + brand + " ingresada ");
        }

        double averageCapacity = filteredVehicles.stream()
                .mapToInt(Vehicle::getPassengers)
                .average()
                .orElse(0);

        return new AverageCapacityDto(brand, averageCapacity);
    }

    //Ejercicio 12: Buscar vehículos por dimensiones
    @Override
    public List<VehicleDto> findByHeightandWidth(double minHeight, double minWidth, double maxHeight, double maxWidth) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> filteresVehicles = vehicleList.stream()
                .filter(v -> v.getWidth() >= minWidth && v.getWidth() <= maxWidth &&
                        v.getHeight() >= minHeight && v.getHeight() <= maxHeight)
                .toList();
        if (filteresVehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehiculos en ese rango");
        }
        return filteresVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    //Ejercicio 13: Listar vehículos por rango de peso
    @Override
    public List<VehicleDto> findByWeightRange(double min, double max) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontro listado de vehiculos");
        }
        List<Vehicle> filteredVehicles = vehicleList.stream()
                .filter(v -> v.getWeight() >= min && v.getWeight() <= max)
                .toList();
        if (filteredVehicles.isEmpty()) {
            throw new NotFoundException(" No se encontraron vehiculos en ese rango");

        }
        return filteredVehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

}







