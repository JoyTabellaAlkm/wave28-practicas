package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.ClothingDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;
import com.mercadolibre.showroom.service.IClothingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothingController {

    private final IClothingService clothingService;

    public ClothingController(IClothingService clothingService) {
        this.clothingService = clothingService;
    }

    // Obtener todas las prendas
    @GetMapping("")
    public ResponseEntity<List<ClothingDTO>> getClothings() {
        return ResponseEntity.ok(clothingService.getClothings());
    }

    // Crear una nueva prenda
    @PostMapping("")
    public ResponseEntity<ClothingDTO> saveClothing(@RequestBody ClothingDTO clothingDTO) {
        return ResponseEntity.ok(clothingService.saveClothing(clothingDTO));
    }

    // Obtener una prenda por su codigo
    @GetMapping("/{code}")
    public ResponseEntity<ClothingDTO> findClothingByCode(@PathVariable Long code) {
        return ResponseEntity.ok(clothingService.findClothingByCode(code));
    }

    // Actualizar una prenda
    @PutMapping("/{id}")
    public ResponseEntity<ClothingDTO> updateClothing(@PathVariable Long id, @RequestBody ClothingDTO clothingDTO) {
        return ResponseEntity.ok(clothingService.updateClothin(id, clothingDTO));
    }

    // Eliminar una prenda
    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> deleteClothing(@PathVariable Long id) {
        return ResponseEntity.ok(clothingService.deleteClothing(id));
    }

    // Obtener prendas por talla
    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothingDTO>> findClothingBySize(@PathVariable String size) {
        return ResponseEntity.ok(clothingService.findBySize(size));
    }

    // Obtener prendas por nombre
    @GetMapping("/filter")
    public ResponseEntity<List<ClothingDTO>> findClothingByName(@RequestParam String name) {
        System.out.println(name);
        return ResponseEntity.ok(clothingService.findByNameContaining(name));
    }

}
