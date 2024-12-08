package com.example.concesionarioautos.controller;

import com.example.concesionarioautos.entity.Vehiculo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/vehicles/")
public class VehiculoController {

    @PostMapping("/")
    public Boolean agregarVehiculo(@RequestBody Vehiculo vehiculo){
    return  null;
    }
}
