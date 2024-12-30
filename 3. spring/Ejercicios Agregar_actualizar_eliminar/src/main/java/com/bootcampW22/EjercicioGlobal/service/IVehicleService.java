package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.*;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface IVehicleService {
    List<VehicleDto> searchAllVehicles();

    //Ejercicio 1: Añadir un vehículo
    ResponseMessageDto addVehicle(VehicleDto vehicleDto);

    //Ejercicio 2: Buscar vehículos por color y año
    List<VehicleDto> findByColorAndYear(String color, int year);

    //Ejercicio 3: Buscar vehículos por marca y rango de años
    List<VehicleDto> findByBrandAndYear(String brand, int start_year, int end_year);

    //Ejercicio 4: Consultar velocidad promedio por marca
    AverageSpeedDto calculateAverageSpeedByBrand(String brand);

    // Ejercicio 5 : Añadir múltiples vehículos
    ResponseMessageDto addVehicles(List<VehicleDto> vehicleDtoList);

    //Ejercicio 6:Actualizar velocidad máxima de un vehículo
    ResponseMessageDto updateMaxSpeed(Long id, MaxSpeedDto maxSpeedDto);

    //Ejercicio7 :Listar vehículos por tipo de combustible
    List<VehicleDto> findByFuelType(String fuelType);

    // Ejercicio 8 :Eliminar un vehículo
    void deleteVehicle(Long id);

    //Ejercicio 9: Buscar vehículos por tipo de transmisión
    List<VehicleDto> findByTypeTransmission(String transmission);

    // Ejercicio 10 :Actualizar el tipo de combustible de un vehículo
    ResponseMessageDto updateByIdFuel(Long id, FuelTypeDto fuelTypeDto);

    //Ejercicio 11: Obtener la capacidad promedio de personas por marca
    AverageCapacityDto calculateAverageCapacityByBrand(String brand);

    //Ejercicio 12: Buscar vehículos por dimensiones
    List<VehicleDto> findByHeightandWidth(double minHeight, double minWidth, double maxHeight, double maxWidth);

    //Ejercicio 13: Listar vehículos por rango de peso
    List<VehicleDto> findByWeightRange(double min, double max);
}