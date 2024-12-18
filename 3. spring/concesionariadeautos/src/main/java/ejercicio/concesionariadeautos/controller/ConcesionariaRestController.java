package ejercicio.concesionariadeautos.controller;


import ejercicio.concesionariadeautos.dto.VehiclesDTO;
import ejercicio.concesionariadeautos.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaRestController {
    @PostMapping()
    private VehiclesDTO agregarVehiculo(){

    }
    @Autowired
    private VehiclesService vehiclesService;
    @GetMapping()
    public ResponseEntity<List<VehiclesDTO>> getVehicles(){
        return new ResponseEntity<List<VehiclesDTO>>(vehiclesService.getVehicles(), HttpStatus.OK);
    }
    @GetMapping("/dates?since{}to{}")
    @GetMapping("/prices?since{}to{}")
    @GetMapping("/{id}")
}
