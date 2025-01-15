package com.bootcamp.clotheses.controller;

import com.bootcamp.clotheses.model.Clothe;
import com.bootcamp.clotheses.service.IClotheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClotheController {
    private final IClotheService clotheService;

    public ClotheController(IClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping
    public ResponseEntity<Clothe> createClothe(@RequestBody Clothe Clothe) {
        Clothe newClothe = clotheService.createClothe(Clothe);
        return ResponseEntity.ok(newClothe);
    }

    @GetMapping
    public ResponseEntity<List<Clothe>> getAllClothes(@RequestParam(required = false) String name) {
        if (name != null) {
            return ResponseEntity.ok(clotheService.getClothesByNameContains(name));
        }
        return ResponseEntity.ok(clotheService.getAllClothes());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Clothe> getClotheByCode(@PathVariable String code) {
        Clothe Clothe = clotheService.getClotheByCode(code);
        if (Clothe != null) {
            return ResponseEntity.ok(Clothe);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<Clothe>> getClothesBySize(@PathVariable String size) {
        return ResponseEntity.ok(clotheService.getClothesBySize(size));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Clothe> updateClothe(@PathVariable String code, @RequestBody Clothe Clothe) {
        Clothe updatedClothe = clotheService.updateClothe(code, Clothe);
        if (updatedClothe != null) {
            return ResponseEntity.ok(updatedClothe);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClothe(@PathVariable String code) {
        boolean deleted = clotheService.deleteClothe(code);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}