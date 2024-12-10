package com.mercadolibre.concesionarioautos.controllers;

import com.mercadolibre.concesionarioautos.dto.CarDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @PostMapping
    public ResponseEntity<?> create(@ResponseBody CarDTO car){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> usedCar(){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> carByDate(){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> carByPrice(){
        return null;
    }

    @GetMapping
    public ResponseEntity<?> carInfo(){
        return null;
    }

}
