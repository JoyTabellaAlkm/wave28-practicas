package com.bootcamp.ejercicio_obras.controller;

import com.bootcamp.ejercicio_obras.model.ObraLiteraria;
import com.bootcamp.ejercicio_obras.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obras")
public class ObraLiterariaController {

    @Autowired
    private ObraLiterariaService service;

    @PostMapping
    public ResponseEntity<ObraLiteraria> createObra(@RequestBody ObraLiteraria obra) {
        return ResponseEntity.ok(service.save(obra));
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByAutor(@PathVariable String autor) {
        return ResponseEntity.ok(service.findByAutor(autor));
    }

    @GetMapping("/nombre/{palabraClave}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByNombreContaining(@PathVariable String palabraClave) {
        return ResponseEntity.ok(service.findByNombreContaining(palabraClave));
    }

    @GetMapping("/top5")
    public ResponseEntity<List<ObraLiteraria>> getTop5Obras() {
        return ResponseEntity.ok(service.findTop5ByOrderByCantidadPaginasDesc());
    }

    @GetMapping("/anio/{anio}")
    public ResponseEntity<List<ObraLiteraria>> getObrasAntesDeElAnio(@PathVariable int anio) {
        return ResponseEntity.ok(service.findByAnioPrimeraPublicacionLessThan(anio));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiteraria>> getObrasByEditorial(@PathVariable String editorial) {
        return ResponseEntity.ok(service.findByEditorial(editorial));
    }
}
