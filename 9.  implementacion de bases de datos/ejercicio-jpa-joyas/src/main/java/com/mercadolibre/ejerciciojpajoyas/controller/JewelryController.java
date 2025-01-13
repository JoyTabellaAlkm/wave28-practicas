package com.mercadolibre.ejerciciojpajoyas.controller;

import com.mercadolibre.ejerciciojpajoyas.dto.CreateJewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.EditJewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.service.IJewelryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {

    IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJewelry(@RequestBody CreateJewelryDTO createJewelryDTO) {
        return new ResponseEntity<>(jewelryService.createJewelry(createJewelryDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewelry(){
        return new ResponseEntity<>(jewelryService.getAllJewelry(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id) {
        return new ResponseEntity<>((jewelryService.softDeleteJewelry(id)), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateJewelry(@PathVariable Long id,
                                           @RequestBody EditJewelryDTO editJewelryDTO) {
        return new ResponseEntity<>(jewelryService.editJewelry(id, editJewelryDTO), HttpStatus.OK);
    }

}
