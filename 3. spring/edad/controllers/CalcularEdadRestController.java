package com.example.edad.controllers;

import com.example.edad.services.impl.CalcularEdadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo/v0.3")
public class CalcularEdadRestController {

    @Autowired
    private CalcularEdadServiceImpl calcularEdadService;

    @GetMapping("/calcularEdad/{day}/{month}/{year}")
    public String calcularEdad(@PathVariable int day,
                               @PathVariable int month,
                               @PathVariable int year){

        return "Edad es : " + calcularEdadService.calcularEdad(day, month, year);
    }
}
