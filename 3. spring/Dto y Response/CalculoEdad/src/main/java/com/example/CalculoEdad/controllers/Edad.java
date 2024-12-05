package com.example.CalculoEdad.controllers;

import com.example.CalculoEdad.CalculoEdadApplication;
import com.example.CalculoEdad.services.CalcularEdadServiceImpl;
import com.example.CalculoEdad.services.ICalcularEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Edad {

    @Autowired
    private ICalcularEdadService calcularEdadService;

//    private final ICalcularEdadService calcularEdadService;
//    public Edad(ICalcularEdadService calcularEdadService){
//        this.calcularEdadService = calcularEdadService;
//    }

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Integer> calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return ResponseEntity.ok(calcularEdadService.calcularEdad(dia, mes, anio));
    }

    @GetMapping("/ejemploRequestParam")
    public ResponseEntity<Integer> calcularEdadParam(@RequestParam int dia, @RequestParam int mes, @RequestParam int anio){
        return ResponseEntity.ok(calcularEdadService.calcularEdad(dia, mes, anio));
    }
}