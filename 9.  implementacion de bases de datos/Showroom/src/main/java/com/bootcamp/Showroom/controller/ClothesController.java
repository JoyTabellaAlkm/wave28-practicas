package com.bootcamp.Showroom.controller;

import com.bootcamp.Showroom.dto.ClothDto;
import com.bootcamp.Showroom.dto.MessageDto;
import com.bootcamp.Showroom.service.IClothService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final IClothService clothService;

    public ClothesController(IClothService clothService) {
        this.clothService = clothService;
    }

    @PostMapping("")
    ResponseEntity<MessageDto> createClothes(@RequestBody ClothDto cloth) {
        clothService.create(cloth);
        return new ResponseEntity<>(new MessageDto("Prenda creada."), HttpStatus.CREATED);
    }

    @GetMapping("")
    ResponseEntity<List<ClothDto>> getAllClothes() {
        return new ResponseEntity<>(clothService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    ResponseEntity<ClothDto> getClothesByCode(@PathVariable Integer code) {
        return new ResponseEntity<>(clothService.getClothByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    ResponseEntity<MessageDto> updateClothe(@PathVariable Integer code, @RequestBody ClothDto cloth) {
        clothService.updateCloth(code, cloth);
        return new ResponseEntity<>(new MessageDto("Prenda actualizada."), HttpStatus.OK);
    }
    @DeleteMapping("/{code}")
    ResponseEntity<MessageDto> deleteClothes(@PathVariable Integer code) {
        clothService.deleteCloth(code);
        return new ResponseEntity<>(new MessageDto("Prenda borrada."), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{size}")
    ResponseEntity<List<ClothDto>> getClothesBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothService.getClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("/by-name")
    ResponseEntity<List<ClothDto>> searchClothesByName(@RequestParam String name) {
        return new ResponseEntity<>(clothService.getClothesByName(name), HttpStatus.OK);
    }
}
