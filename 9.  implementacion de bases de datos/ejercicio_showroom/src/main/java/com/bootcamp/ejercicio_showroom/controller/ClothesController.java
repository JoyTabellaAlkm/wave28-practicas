package com.bootcamp.ejercicio_showroom.controller;

import com.bootcamp.ejercicio_showroom.model.Clothes;
import com.bootcamp.ejercicio_showroom.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private ClothesService clothesService;

    @PostMapping
    public ResponseEntity<Clothes> createClothes(@RequestBody Clothes clothes) {
        return new ResponseEntity<>(clothesService.createClothes(clothes), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Clothes> getClothesByCode(@PathVariable String code) {
        Optional<Clothes> clothes = clothesService.getClothesByCode(code);
        return clothes.map(c -> new ResponseEntity<>(c, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{code}")
    public ResponseEntity<Clothes> updateClothes(@PathVariable String code, @RequestBody Clothes clothes) {
        return new ResponseEntity<>(clothesService.updateClothes(code, clothes), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClothes(@PathVariable String code) {
        clothesService.deleteClothes(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(params = "size")
    public List<Clothes> getClothesBySize(@RequestParam String size) {
        return clothesService.getClothesBySize(size);
    }

    @GetMapping(params = "name")
    public List<Clothes> searchClothesByName(@RequestParam String name) {
        return clothesService.searchClothesByName(name);
    }
}
