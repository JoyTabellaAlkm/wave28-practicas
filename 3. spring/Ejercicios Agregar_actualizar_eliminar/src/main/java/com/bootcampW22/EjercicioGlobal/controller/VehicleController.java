package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.*;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles() {
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }


    //Ejercicio 1 Añadir un vehiculo
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);

    }

    // Ejercicio 2: Buscar vehículos por color y año
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByColorAndYear(
            @PathVariable String color,
            @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.findByColorAndYear(color, year), HttpStatus.OK);
    }

    //Ejercicio 3: Buscar vehículos por marca y rango de años
    @GetMapping("vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByBrandAndYear(
            @PathVariable String brand,
            @PathVariable int start_year,
            @PathVariable int end_year) {

        return new ResponseEntity<>(vehicleService.findByBrandAndYear(brand, start_year, end_year), HttpStatus.OK);

    }

    //Ejercicio 4: Consultar velocidad promedio por marca
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<AverageSpeedDto> getAverageSpedByBrand
    (@PathVariable String brand) {

        return new ResponseEntity<>(vehicleService.calculateAverageSpeedByBrand(brand), HttpStatus.OK);
    }

    // Ejercicio 5:  Añadir multiples vehiculos
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addVehicles(@RequestBody List<VehicleDto> vehicleDtoList) {
        return new ResponseEntity<>(vehicleService.addVehicles(vehicleDtoList), HttpStatus.CREATED);

    }

    // Ejercicio 6: Actualizar velocidad máxima de un vehiculo
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<ResponseMessageDto> updateSpeedId(@PathVariable Long id, @RequestBody MaxSpeedDto maxSpeedDto) {
        return new ResponseEntity<>(vehicleService.updateMaxSpeed(id, maxSpeedDto), HttpStatus.OK);
    }

    //Ejercicio7 :Listar vehículos por tipo de combustible
    @GetMapping("/vehicles/fuel_type/{fuel_type}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByFuelType(
            @PathVariable String fuel_type) {

        return new ResponseEntity<>(vehicleService.findByFuelType(fuel_type), HttpStatus.OK);
    }

    /*
        //Ejercicio 8: Eliminar un vehiculo
        @DeleteMapping("/vehicles/{id}")
        public ResponseEntity<ResponseMessageDto> deleteVehicle(@PathVariable Long id) {
            return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.NO_CONTENT);

        }
    */
    //Ejercicio 8: Eliminar un vehiculo
    @DeleteMapping("vehicles/{id}")
    ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }


    // Ejercicio 9: Buscar vehículos por tipo de transmisión
    @GetMapping("vehicles/transmission/{transmission}")
    public ResponseEntity<List<VehicleDto>> getVehiclesByTypeTransmission(
            @PathVariable String transmission) {

        return new ResponseEntity<>(vehicleService.findByTypeTransmission(transmission), HttpStatus.OK);

    }

    // Ejercicio 10 :Actualizar el tipo de combustible de un vehículo
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> UpdateFuelById(@PathVariable Long id, @RequestBody FuelTypeDto fuelTypeDto) {
        return new ResponseEntity<>(vehicleService.updateByIdFuel(id, fuelTypeDto), HttpStatus.OK);

    }

    //Ejercicio 11: Obtener la capacidad promedio de personas por marca
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<AverageCapacityDto> getAverageCapacityByBrand
    (@PathVariable String brand) {

        return new ResponseEntity<>(vehicleService.calculateAverageCapacityByBrand(brand), HttpStatus.OK);
    }

    //Ejercicio 12: Buscar vehículos por dimensiones
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(
            @RequestParam String height,
            @RequestParam String width) {

        // Separar los valores de altura
        String[] heightValues = height.split("-");
        double minHeight = Double.parseDouble(heightValues[0]);
        double maxHeight = Double.parseDouble(heightValues[1]);

        // Separar los valores de ancho
        String[] widthValues = width.split("-");
        double minWidth = Double.parseDouble(widthValues[0]);
        double maxWidth = Double.parseDouble(widthValues[1]);

        // Llamar al servicio
        List<VehicleDto> vehicles = vehicleService.findByHeightandWidth(minHeight, minWidth, maxHeight, maxWidth);

        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    //Ejercicio 13: Listar vehículos por rango de peso
    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWight(
            @RequestParam double min,
            @RequestParam double max) {

        return new ResponseEntity<>(vehicleService.findByWeightRange(min, max), HttpStatus.OK);
    }


}
