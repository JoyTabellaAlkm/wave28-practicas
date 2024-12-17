package com.nombres.starwars.controller;

import com.nombres.starwars.service.INombre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/starwars")
public class Nombre {

    @Autowired
    private INombre nombreService;

    @GetMapping("/nombres/{nombre}")
    public ResponseEntity<?> findPersonajes(@PathVariable String nombre){
        return ResponseEntity.ok(nombreService.obtenerNombre(nombre));
    }
}

