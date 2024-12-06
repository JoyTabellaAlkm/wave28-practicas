package com.primer_proyecto_spring.pruebaspring.controllers;

import com.primer_proyecto_spring.pruebaspring.services.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcularEdadController {

    @GetMapping("/edad/{dia}/{mes}/{año}")
    public String recibirFechaNacimiento(
            @PathVariable String dia,
            @PathVariable String mes,
            @PathVariable String año) {

        System.out.println("Fecha de nacimiento: " + dia + "/" + mes + "/" + año);

        return "La edad de alguien nacido el: " +dia +"/"+mes+"/"+ año + " es: " + EdadService.calcularEdad(dia, mes, año);
    }
}