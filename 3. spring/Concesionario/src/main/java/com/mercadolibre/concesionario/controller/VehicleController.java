package com.mercadolibre.concesionario.controller;

import com.mercadolibre.concesionario.model.Vehicle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/vehicles")
public class VehicleController {

    @GetMapping("")
    public String test(){
        Vehicle test = new Vehicle();
        test.getModel();
        return "";
    }

}
