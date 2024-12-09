package com.concesionariaapi.concesionaria.controller;
import com.concesionariaapi.concesionaria.dto.VehiculoDTO;
import com.concesionariaapi.concesionaria.model.Vehiculo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionariaController {

    @PostMapping("")
    public ResponseEntity<?> addVehicle(@RequestBody VehiculoDTO vehiculoDTO){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllVehicles(){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/dates")
    public ResponseEntity<?> getByManufacturingDate(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/prices")
    public ResponseEntity<?> getByPrice(@RequestParam String since, @RequestParam String to){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
