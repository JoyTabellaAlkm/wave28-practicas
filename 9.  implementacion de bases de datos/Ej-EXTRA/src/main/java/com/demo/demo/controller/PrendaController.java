package com.demo.demo.controller;

import com.demo.demo.dto.PrendaDTO;
import com.demo.demo.service.IPrendaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    private final IPrendaService service;

    public PrendaController(IPrendaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createPrenda(@RequestBody PrendaDTO prenda) {
        return ResponseEntity.ok(service.save(prenda));
    }

    @GetMapping
    public ResponseEntity<?> getAllPrendas(@RequestParam(required = false) String name) {
        if(name != null) {
            return ResponseEntity.ok(service.findAllByName(name));
        }
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> showPrenda(@PathVariable String code) {
        return ResponseEntity.ok(service.findById(code));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deletePrenda(@PathVariable String code) {
        return ResponseEntity.ok(service.delete(code));
    }
}