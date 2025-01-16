package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaDto;
import com.mercadolibre.showroom.service.IPrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private final IPrendaService prendaService;

    public PrendaController(IPrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPrenda(@RequestBody PrendaDto prendaDto) {
        if (prendaService.createPrenda(prendaDto)) {
            return ResponseEntity.ok("Prenda creada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getPrendas() {
        return ResponseEntity.ok(prendaService.getPrendas());
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<?> getPrendaByCode(@PathVariable Long code) {
        return ResponseEntity.ok(prendaService.getPrendaByCode(code));
    }

    @PutMapping("/update/{code}")
    public ResponseEntity<?> updatePrenda(@PathVariable Long code, @RequestBody PrendaDto prendaDto) {
        if(prendaService.updatePrenda(code, prendaDto)) {
            return ResponseEntity.ok("Prenda actualizada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{code}")
    public ResponseEntity<?> deletePrenda(@PathVariable Long code) {
        if(prendaService.deletePrenda(code)) {
            return ResponseEntity.ok("Prenda eliminada correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getPrendasBySize(@PathVariable String size) {
        return ResponseEntity.ok(prendaService.getPrendasBySize(size));
    }

    // Buscar todas las prendas en cuyo nombre aparezca la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas
    @GetMapping("/name")
    public ResponseEntity<?> getPrendasByName(@RequestParam String name) {
        return ResponseEntity.ok(prendaService.getPrendasByName(name));
    }
}
