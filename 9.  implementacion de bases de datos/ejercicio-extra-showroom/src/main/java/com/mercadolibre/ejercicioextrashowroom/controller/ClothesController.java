package com.mercadolibre.ejercicioextrashowroom.controller;

import com.mercadolibre.ejercicioextrashowroom.dto.request.CreateClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.service.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    IClothesService clothesService;

    public ClothesController(IClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping()
    public ResponseEntity<?> createClothes(@RequestBody CreateClothesDTO clothesDTO) {
        return new ResponseEntity<>(clothesService.createClothes(clothesDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllClothes() {
        return new ResponseEntity<>(clothesService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClothesById(@PathVariable Long id) {
        return new ResponseEntity<>(clothesService.getClothesById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClothes(@PathVariable Long id,
                                           @RequestBody CreateClothesDTO clothesDTO) {
        return new ResponseEntity<>(clothesService.updateClothes(id, clothesDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClothes(@PathVariable Long id) {
        return new ResponseEntity<>(clothesService.deleteClothes(id), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getClothesBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothesService.getClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchClothesByName(@RequestParam String query) {
        return new ResponseEntity<>(clothesService.searchClothesByName(query), HttpStatus.OK);
    }

}
