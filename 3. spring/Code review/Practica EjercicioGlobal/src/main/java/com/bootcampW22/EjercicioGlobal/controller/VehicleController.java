package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleDto> crearVehiculo(@RequestBody Vehicle vehiculo){
        return new ResponseEntity<>(vehicleService.crearVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> vehiculosColoryAnio(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.vehiculoColoryAnio(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> vehiculosMarcayAnio(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.vehiculoMarcayAnio(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping ("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<String> velocidadPromedioxMarca(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.promedioVelocidadxMarca(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<String> crearVehiculos(@RequestBody List<Vehicle> vehiculos){
        return new ResponseEntity<>(vehicleService.crearVehiculos(vehiculos), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<VehicleDto> actualizarVelocidad(@PathVariable int id, @RequestParam int velocidad){
        return new ResponseEntity<>(vehicleService.actualizarVelocidad(id, velocidad), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<String> eliminarVehiculo(@PathVariable int id){
        return new ResponseEntity<>(vehicleService.eliminarVehiculo(id), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<String> actualizarCombustible(@PathVariable int id){
        return null;
    }
}
