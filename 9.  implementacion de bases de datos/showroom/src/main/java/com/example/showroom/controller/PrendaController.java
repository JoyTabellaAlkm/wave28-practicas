package com.example.showroom.controller;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {
    @Autowired
    PrendaService prendaService;

    @PostMapping
    public ResponseEntity<?> postPrenda(@RequestBody PrendaDto prendaDto) {
        return ResponseEntity.ok().body(prendaService.postPrenda(prendaDto));
    }

    @GetMapping
    public ResponseEntity<?> getPrendas(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok().body(prendaService.findPrendasNombre(name));
        }
        return ResponseEntity.ok().body(prendaService.getPrendas());
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<?> getPrendasByCodigo(@PathVariable Long code) {
        return ResponseEntity.ok().body(prendaService.findPrendaCode(code));
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> putPrenda(@PathVariable Long code, @RequestBody PrendaDto prendaDto) {
        return ResponseEntity.ok().body(prendaService.putPrenda(code, prendaDto));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> deletePrenda(@PathVariable Long code) {
        prendaService.deletePrenda(code);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/size/{size}")
    public ResponseEntity<?> getPrendasByTalle(@PathVariable String size){
        return ResponseEntity.ok().body(prendaService.findPrendasTalle(size));
    }

}
