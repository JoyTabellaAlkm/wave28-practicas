package com.demo.demo.controller;


import com.demo.demo.service.ICalculadorDeEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class CalculadorDeEdadController {
    @Autowired
    ICalculadorDeEdadService calculadorEdad;

    @GetMapping("{dia}/{mes}/{anio}")
    public int calcularEdad(
            @PathVariable int dia,
            @PathVariable int mes,
            @PathVariable int anio
    ) {
        LocalDate fechaDeNacimiento = LocalDate.of(anio, mes, dia);
        return calculadorEdad.calcularEdad(fechaDeNacimiento);
    }
}