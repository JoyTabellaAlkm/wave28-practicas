package com.bootcamp.ejercicioDeportistas.controller;

import com.bootcamp.ejercicioDeportistas.service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/findSports")
public class DeporteController {

    private final DeporteService deporteService;

    @Autowired
    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    /*
        Ver todos los deportes que tenemos cargados.
        PATH: /findSports
    */
    @GetMapping("")
    public String getDeportes() {
        return deporteService.getDeportes();
    }

    /* Consultar si existe un deporte ingresando su nombre.
    De existir, se deberá mostrar el nivel del mismo.
    Utilizar la clase ResponseEntity para devolver la respuesta.
    PATH: /findSport/{name}
     */
    @GetMapping("/{name}")
    public ResponseEntity<String> getDeporteByName(@PathVariable String name) {
        return deporteService.getDeportesByName(name)
                .map(nivel -> ResponseEntity.ok("El nivel del deporte " + name + " es: " + nivel))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}
