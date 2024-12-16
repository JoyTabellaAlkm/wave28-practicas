package com.bootcampW22.EjercicioGlobal.service;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.IdYaExistente;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.FormatoError;
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
    public String addVehicle(VehicleDto vehicleDto) {
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleDto == null) {
            throw new NotFoundException("No existe vehiculo cargado");
        }
        if (vehicleRepository.existsById(vehicleDto.getId())) {
            throw new IdYaExistente("El identificador del vehiculo ya existe");
        }
        Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
        vehicleRepository.save(vehicle);
        return "Vehículo creado exitosamente con ID: " + vehicle.getId();
    }

    // Ejercicio 5 : Añadir múltiples vehículos
    @Override
    public String addVehicles(List<VehicleDto> vehicleDtos) {
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleDtos.isEmpty()) {
            throw new NotFoundException("La lista de vehiculos no puede estar vacia");
        }
        for (VehicleDto vehicleDto : vehicleDtos) {
            if (vehicleRepository.existsById(vehicleDto.getId()))
                throw new IdYaExistente("Vehiculo ya existente");

        }

        vehicleDtos.stream().map(v -> mapper.convertValue(v, Vehicle.class))
                .toList()
                .forEach(vehicleRepository::save);

        return "Todos los vehículos fueron creados exitosamente";
    }

    // Ejercicio 8 :Eliminar un vehículo

    @Override
    public String deleteVehicle(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new NotFoundException("el ID ingresado " + id + " no existe");
        }
        vehicleRepository.DeleteID(id);
        return ("el vehiculo con id " + id + " fue eliminado correctamente");


    }

    //Ejercicio 6:Actualizar velocidad máxima de un vehículo
    public String updateMax_speed(Long id, String maxSpeed) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe el ID ingresado"));

        if (!maxSpeed.matches("\\d+")) {
            throw new FormatoError("La velocidad mal formada, debe ser un número entero positivo.");
        }
        vehicle.setMax_speed(maxSpeed);

        vehicleRepository.save(vehicle);

        return "La velocidad máxima del vehículo con ID " + id + " se actualizó correctamente.";

    }

    // Ejercicio 10 :Actualizar el tipo de combustible de un vehículo
    @Override
    public String updateByIdFuel(Long id, String fuelType) {
        Vehicle vehicle= vehicleRepository.findById(id)
                .orElseThrow(()->new NotFoundException("No existe el id Ingresado"));

        if(!fuelType.matches("^[a-zA-Z]+$")){
            throw new FormatoError("El tipo de combustible mal formado, no se aceptan numeros");
        }
        vehicle.setFuel_type(fuelType);
        vehicleRepository.save(vehicle);
        return "El tipo de combustible del vehiculo con id " + id + "fue actualizado" ;
    }

}







