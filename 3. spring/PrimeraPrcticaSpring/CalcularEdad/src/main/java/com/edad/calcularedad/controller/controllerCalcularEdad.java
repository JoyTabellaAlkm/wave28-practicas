package com.edad.calcularedad.controller;

import com.edad.calcularedad.service.serviceCalcularEdad;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/calcular", produces = MediaType.APPLICATION_JSON_VALUE)

public class controllerCalcularEdad {

    private serviceCalcularEdad calcularEdadService = new serviceCalcularEdad();

    @GetMapping("/edad")
    public String edad(@RequestParam String fecha){
        return calcularEdadService.calcularEdad(fecha);
    }
}
