package com.dario.dominguez.practicaconcesionaria.controller;

import com.dario.dominguez.practicaconcesionaria.dto.VehicleDto;
import com.dario.dominguez.practicaconcesionaria.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/api")
public class ConcesionariaController {

    @Autowired
    IVehicleService vehicleService;

    @PostMapping("/vehicles")
    public ResponseEntity registrerVehicle (@RequestBody VehicleDto vehicleDto){
        vehicleService.addVehicle(vehicleDto);
        return ResponseEntity.status(HttpStatus.OK).body("Se agrego correctamente");
    }

    @GetMapping("/vehicles")
    public ResponseEntity<List<VehicleDto>> getAllVehicles (){
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehicles());
    }

    @GetMapping("/vehicles/dates")
    public ResponseEntity<List<VehicleDto>> getSinceTo (@RequestParam String since, @RequestParam String to){
        System.out.println("Entro por el controller correcto");
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getSinceTo(since, to));
    }
}
