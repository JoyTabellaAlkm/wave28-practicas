package com.ar.mercadolibre.showroom.controller;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import com.ar.mercadolibre.showroom.service.IClotheService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ClotheDTO> create(@RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.create(clotheDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClotheDTO>> getAll(@RequestParam(required = false) String name) {
        return new ResponseEntity<>(clotheService.getClothes(name), HttpStatus.OK);
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<ClotheDTO> getById(@PathVariable Long code) {
        return new ResponseEntity<>(clotheService.getById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public  ResponseEntity<ClotheDTO> update(@PathVariable Long code, @RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.update(code, clotheDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long code) {
        clotheService.delete(code);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClotheDTO>> getBySize(@PathVariable String size) {
        return new ResponseEntity<>(clotheService.getBySize(size), HttpStatus.OK);
    }
}
