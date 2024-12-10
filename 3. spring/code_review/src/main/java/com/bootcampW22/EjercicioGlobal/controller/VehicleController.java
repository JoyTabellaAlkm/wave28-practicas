package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.FuelDto;
import com.bootcampW22.EjercicioGlobal.dto.SpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {


    @Autowired
    private IVehicleService vehicleService;

    @GetMapping()
    public ResponseEntity<?> getVehicles() {
        return ResponseEntity.ok(vehicleService.searchAllVehicles());
    }

    //    1.Añadir un vehículo
    @PostMapping()
    public ResponseEntity<?> saveVehicle(@RequestBody VehicleDto vehicleDto) {
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicleDto), HttpStatus.CREATED);
    }

    //    2.Buscar vehículos por color y año
    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getVehicleByColorAndYear(@PathVariable String color,
                                                      @PathVariable int year) {
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color, year),
                HttpStatus.OK);
    }

    //    3.Buscar vehículos por marca y rango de años
    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> getVehicleByBrandAndRangeYear(@PathVariable String brand,
                                                           @PathVariable int startYear,
                                                           @PathVariable int endYear) {
        return new ResponseEntity<>(vehicleService.searchByBrandAndRangeYear(brand, startYear,
                endYear),
                HttpStatus.OK);
    }

    //    4.Consultar velocidad promedio por marca
    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(String.format("%.2f", vehicleService.searchAverageSpeedByBrand(brand)),
                HttpStatus.OK);
    }

    //    5.Añadir múltiples vehículos
    @PostMapping("/batch")
    public ResponseEntity<?> saveManyVehicle(@RequestBody List<VehicleDto> vehicleDto) {
        return new ResponseEntity<>(vehicleService.saveManyVehicle(vehicleDto), HttpStatus.CREATED);
    }

    //    6.Actualizar velocidad máxima de un vehículo
    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@RequestBody SpeedDto speedDto, @PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.updateSpeed(speedDto, id), HttpStatus.OK);
    }

    //    7.Listar vehículos por tipo de combustible
    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> getVehicleByFuel(@PathVariable String type) {
        return new ResponseEntity<>(
                vehicleService.searchByFuelType(type),
                HttpStatus.OK);
    }

    //    8.Eliminar un vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

    //    9.Buscar vehículos por tipo de transmisión
    @GetMapping("/transmission/{type}")
    public ResponseEntity<?> getVehicleByTransmission(@PathVariable String type) {
        return new ResponseEntity<>(
                vehicleService.searchByTransmissionType(type),
                HttpStatus.OK);
    }

    //    10.Listar vehículos por tipo de combustible
    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@RequestBody FuelDto fuelDto, @PathVariable Long id) {
        return new ResponseEntity<>(vehicleService.updateFuel(fuelDto, id), HttpStatus.OK);
    }

    //    11.Listar vehículos por tipo de combustible
    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand) {
        return new ResponseEntity<>(
                Math.round(vehicleService.searchAverageCapacityByBrand(brand)),
                HttpStatus.OK);
    }

    //    12.Listar vehículos por tipo de combustible
    @GetMapping("/dimensions")
    public ResponseEntity<?> getyByDimensions(
            @RequestParam double min_length,
            @RequestParam double max_length,
            @RequestParam double min_width,
            @RequestParam double max_width) {
        return new ResponseEntity<>(
                vehicleService.searchByDemensions(min_length, max_length, min_width, max_width),
                HttpStatus.OK);
    }

    //    13.Listar vehículos por tipo de combustible
    @GetMapping("/weight")
    public ResponseEntity<?> getyByWeight(
            @RequestParam double weight_min,
            @RequestParam double weight_max
            ) {
        return new ResponseEntity<>(
                vehicleService.searchByWeight(weight_min, weight_max),
                HttpStatus.OK);
    }
}
