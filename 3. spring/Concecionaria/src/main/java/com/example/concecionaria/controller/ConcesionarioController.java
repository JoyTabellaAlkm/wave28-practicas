package com.example.concecionaria.controller;


import com.example.concecionaria.dto.VehiclesDto;
import com.example.concecionaria.service.ConsecionariaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1/api/vehicles")
public class ConcesionarioController {

    @Autowired
    private ConsecionariaServiceImpl consecionariaService;

//    @PostMapping()
//    public int postProduct(){
//        return 1;
//    }

    @GetMapping()
    public List<VehiclesDto> getProducts(){
        List<VehiclesDto> vehicles = consecionariaService.getProducts();
        System.out.println(vehicles);
        return vehicles;
    }

    @GetMapping("/dates")
    public List<VehiclesDto> getProductsByDateOfCreation(@RequestParam String since, @RequestParam String to){
        LocalDate sinceDate = LocalDate.parse(since.trim());
        LocalDate toDate = LocalDate.parse(to.trim());
        List<VehiclesDto> vehicles = consecionariaService.getProductsByDateOfCreation(sinceDate,toDate);
        System.out.println(vehicles);
        return vehicles;
    }

    @GetMapping("/price")
    public List<VehiclesDto> getProductsByPrice(@RequestParam int since, @RequestParam int to){

        List<VehiclesDto> vehicles = consecionariaService.getProductsByPrice(since,to);
        System.out.println(vehicles);
        return vehicles;
    }

}
