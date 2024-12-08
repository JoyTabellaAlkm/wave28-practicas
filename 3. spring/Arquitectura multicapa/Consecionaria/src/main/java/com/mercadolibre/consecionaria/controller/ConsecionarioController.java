package com.mercadolibre.consecionaria.controller;

import com.mercadolibre.consecionaria.dto.VehiclesDtoResponse;
import com.mercadolibre.consecionaria.dto.VehiclesWithoutServicesDtoResponse;
import com.mercadolibre.consecionaria.entity.Vehicles;
import com.mercadolibre.consecionaria.service.IVehicles;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConsecionarioController {

    @Autowired
    private IVehicles vehiclesService;

    @PostMapping
    ResponseEntity<VehiclesDtoResponse> crearVehiculo(@RequestBody Vehicles vehiculo){
        return ResponseEntity.ok(vehiclesService.crearVehiculo(vehiculo));
    }

    @GetMapping
    ResponseEntity<List<VehiclesWithoutServicesDtoResponse>> vehiculosUsados(){
        return ResponseEntity.ok(vehiclesService.devolverVehiculos());
    }

    @GetMapping("/dates")
    ResponseEntity<List<VehiclesDtoResponse>> vehiculosXFecha(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(vehiclesService.devolverVehiculosXFecha(since, to));
    }

    @GetMapping("/prices")
    ResponseEntity<List<VehiclesDtoResponse>> vehiculosXPrecio(@RequestParam int since, @RequestParam int to){
        return ResponseEntity.ok(vehiclesService.devolverVehiculosXPrecio(since, to));
    }

    @GetMapping("/{id}")
    ResponseEntity<VehiclesDtoResponse> vehiculosxId(@PathVariable int id){
        return ResponseEntity.ok(vehiclesService.devolverVehiculoXId(id));
    }
}
