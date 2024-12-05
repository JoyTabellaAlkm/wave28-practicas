package com.edad.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/")
public class EdadController {
    @GetMapping("{dia}/{mes}/{anio}")
    public int CalcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate localTime = LocalDate.now();
        LocalDate birthdayTime = LocalDate.of(anio, mes, dia);
        Period edad = Period.between(birthdayTime, localTime);

        return edad.getYears();
    }
}