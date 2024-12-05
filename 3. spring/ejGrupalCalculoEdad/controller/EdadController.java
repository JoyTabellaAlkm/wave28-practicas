package com.miprimerproyecto.proyectospring.ejCalculoEdad.controller;


import com.miprimerproyecto.proyectospring.ejCalculoEdad.service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EdadController {

    @Autowired
    IEdadService edadService;

    @GetMapping("edad/{dia}/{mes}/{anio}")
    public Integer calcularEdad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        try {
            return edadService.calcularEdad(dia, mes, anio);
        } catch (Exception e) {
            return 0;
        }
    }
}