package org.bootcampmeli.ejercicioconcesionaria.controller;



import org.bootcampmeli.ejercicioconcesionaria.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bootcampmeli.ejercicioconcesionaria.dto.VehiculoDTO;


@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaController {

    @Autowired
    VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<Long> addVehicle(@RequestBody VehiculoDTO vehicleDTO) {
        Long createdVehicle = vehiculoService.insertVehiculo(vehicleDTO);
        return new ResponseEntity<>(createdVehicle, HttpStatus.CREATED);
    }

}
