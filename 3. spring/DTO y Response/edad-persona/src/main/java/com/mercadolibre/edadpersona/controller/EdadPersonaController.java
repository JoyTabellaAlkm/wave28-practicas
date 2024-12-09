package com.mercadolibre.edadpersona.controller;

import com.mercadolibre.edadpersona.service.IEdadPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadPersonaController {

    @Autowired
    private IEdadPersonaService edadPersonaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String devolverEdadPersona(@PathVariable int dia,
                                   @PathVariable int mes,
                                   @PathVariable int anio){

        return edadPersonaService.calcularEdadPersona(dia, mes, anio);
    }

    //Con try catch
    @GetMapping("/edad/{dia}/{mes}/{anio}")
    public String devolverEdadPersona1(@PathVariable int dia,
                                      @PathVariable int mes,
                                      @PathVariable int anio){

        int edad = edadPersonaService.calcularEdadPersona1(dia, mes, anio);
        return edad == -1 ? "Error: Mal ingresado en la fecha" : String.valueOf(edad);
    }

}
