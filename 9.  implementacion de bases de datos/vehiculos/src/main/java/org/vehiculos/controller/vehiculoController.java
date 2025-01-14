package org.vehiculos.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vehiculos.entity.Vehiculo;
import org.vehiculos.service.iVehiculoService;

import javax.xml.transform.OutputKeys;
import java.util.List;

@RestController
public class vehiculoController {

    @Autowired
    private iVehiculoService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Vehiculo>> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findMarcaPatente")
    public ResponseEntity<List<Object[]>> getMarcaPatente() {
        return new ResponseEntity<>(service.findMarcaPatente(), HttpStatus.OK);
    }

    @GetMapping("/masCuatro")
    public ResponseEntity<List<String>> getMasCuatroRuedas() {
        return new ResponseEntity<>(service.findAllRuedasMayorACuatro(), HttpStatus.OK);
    }

    @GetMapping("/SiniestrosMayor")
    public ResponseEntity<List<Object[]>> getSiniestrosMayor() {
        return new ResponseEntity<>(service.findAllVehiculosSiniestros(), HttpStatus.OK);
    }

    @GetMapping("/perdidaTotal")
    public ResponseEntity<List<Object[]>> getPerdidaTotal() {
        return new ResponseEntity<>(service.findAllSiniestroPerdidaTotal(), HttpStatus.OK);
    }
}
