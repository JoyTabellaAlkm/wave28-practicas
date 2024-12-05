package com.example.ejerciciodeportistas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {

    @Autowired
    private DeportesService deportesService;

    @GetMapping("/findSports")
    public ResponseEntity<List<Deporte>> listarDeportes(){
        List<Deporte> listaDeportes = deportesService.listarDeportes();
        System.out.println(listaDeportes);
        return ResponseEntity.ok(listaDeportes);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<Optional<Deporte>> listarDeportesPorNombre(@PathVariable String name){
        Optional<Deporte> deportePorNombre = deportesService.listarDeportePorNombre(name);
        System.out.println(deportePorNombre);
        return ResponseEntity.ok(deportePorNombre);
    }



}
