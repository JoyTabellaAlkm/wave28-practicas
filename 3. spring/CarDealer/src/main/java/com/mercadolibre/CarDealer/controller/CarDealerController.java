package com.mercadolibre.CarDealer.controller;

import com.mercadolibre.CarDealer.dto.CarDTO;
import com.mercadolibre.CarDealer.service.ICarDealearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@RestController
@RequestMapping("v1/api/")
public class CarDealerController {
    @Autowired
    ICarDealearService service;

    @PostMapping("/vehicules")
    public ResponseEntity<?> addCar(@RequestBody CarDTO car){
        service.addCar(car);
        return new ResponseEntity<String>("Registro correcto", HttpStatus.CREATED);
    }
    @GetMapping("/vehicules")
    public ResponseEntity<List<CarDTO>> findCarBydates(){
        return new ResponseEntity<List<CarDTO>>(service.listWithOutServices(), HttpStatus.CREATED);
    }
    @GetMapping("/vehicules/dates")
    public ResponseEntity<List<CarDTO>> findCarBydates(@RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
                                                       @RequestParam  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        return new ResponseEntity<List<CarDTO>>(service.findByDate(since,to), HttpStatus.CREATED);


    }
    @GetMapping("/vehicules/prices")
    public ResponseEntity<List<CarDTO>> findCarByPrices(@RequestParam int since,@RequestParam int to){
        return new ResponseEntity<List<CarDTO>>(service.findByPrice(since,to), HttpStatus.CREATED);
    }
    @GetMapping("/vehicules/{id}")
    public ResponseEntity<List<CarDTO>> findCarById(@PathVariable int id){
        return new ResponseEntity<List<CarDTO>>(service.findById(id), HttpStatus.CREATED);
    }


}
