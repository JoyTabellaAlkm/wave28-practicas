package org.bootcampmeli.empresaseguros.controller;

import org.bootcampmeli.empresaseguros.Service.IVehiculoService;
import org.bootcampmeli.empresaseguros.Service.VehiculoService;
import org.bootcampmeli.empresaseguros.model.Siniestro;
import org.bootcampmeli.empresaseguros.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/siniestro")
    public ResponseEntity<?> getSiniestros() {
        return new ResponseEntity<>(vehiculoService.getSiniestros(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createVehiculo(@RequestBody Vehiculo vehiculo) {
        return new ResponseEntity<>(vehiculoService.createVehiculo(vehiculo), HttpStatus.CREATED);
    }

    @PostMapping("/siniestro")
    public ResponseEntity<?> createSiniestro(@RequestBody Siniestro siniestro) {
        return  new ResponseEntity<>(vehiculoService.createSiniestro(siniestro), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getVehiculos() {

        return new ResponseEntity<>(vehiculoService.getVehiculos(), HttpStatus.OK);
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getPatentes() {
        return new ResponseEntity<>(vehiculoService.getPatentes(), HttpStatus.OK);
    }
}
