package com.mercadolibre.ejerciciodeportistas.controller;

import com.mercadolibre.ejerciciodeportistas.model.Deporte;
import com.mercadolibre.ejerciciodeportistas.service.DeportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeportesController {

    @Autowired
    private DeportesService deportesService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> listarDeportes(){
        List<Deporte> listaDeportes = deportesService.listarDeportes();
        return ResponseEntity.ok(listaDeportes);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Deporte> listarDeportesPorNombre(@PathVariable String name){
        Deporte deportePorNombre = deportesService.listarDeportePorNombre(name);
        return ResponseEntity.ok(deportePorNombre);
    }

}
