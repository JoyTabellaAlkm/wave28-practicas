package org.bootcampmeli.ejercitacionextra.controller;

import org.bootcampmeli.ejercitacionextra.dto.PrendaDto;
import org.bootcampmeli.ejercitacionextra.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clothes")
public class PrendaController {

    @Autowired
    private IPrendaService prendaService;

    @PostMapping()
    public ResponseEntity<?> addPrenda(@RequestBody PrendaDto prendadto) {
        return new ResponseEntity<>(prendaService.addPrenda(prendadto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllPrendas() {
        return new ResponseEntity<>(prendaService.getAllPrendas(), HttpStatus.OK);
    }

    @GetMapping("{code}")
    public ResponseEntity<?> getPrendaByCode(@PathVariable String code) {
        return new ResponseEntity<>(prendaService.getPrendaByCode(code), HttpStatus.OK);
    }

    @PutMapping("{code}")
    public ResponseEntity<?> updatePrenda(@PathVariable String code, @RequestBody PrendaDto prendadto) {
        return new ResponseEntity<>(prendaService.updatePrenda(code, prendadto), HttpStatus.OK);
    }

    @DeleteMapping("{code}")
    public ResponseEntity<?> deletePrenda(@PathVariable String code) {
        return new ResponseEntity<>(prendaService.deletePrenda(code), HttpStatus.OK);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<?> getPrendaBySize(@PathVariable String size) {
        return new ResponseEntity<>(prendaService.getBySize(size),HttpStatus.OK);
    }

    @GetMapping("by")
    public ResponseEntity<?> getByName(@RequestParam("name") String name ) {
        return new ResponseEntity<>(prendaService.getByName(name),HttpStatus.OK);
    }
}
