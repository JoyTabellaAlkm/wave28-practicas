package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.ClotheDTO;
import com.mercadolibre.showroom.service.IClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clothes")
public class ClotheController {

    @Autowired
    private IClotheService clotheService;

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.create(clotheDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(clotheService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findClotheByCode(@PathVariable String code) {
        return new ResponseEntity<>(clotheService.findClotheByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@PathVariable String code,@RequestBody ClotheDTO clotheDTO) {
        return new ResponseEntity<>(clotheService.update(code,clotheDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable String code) {
        return new ResponseEntity<>(clotheService.delete(code), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> findClotheBySize(@PathVariable Float size) {
        return new ResponseEntity<>(clotheService.findClotheBySize(size), HttpStatus.OK);
    }

    @GetMapping("/byName")
    public ResponseEntity<?> findClotheByName(@RequestParam String name) {
        return new ResponseEntity<>(clotheService.findClotheByName(name), HttpStatus.OK);
    }

}
