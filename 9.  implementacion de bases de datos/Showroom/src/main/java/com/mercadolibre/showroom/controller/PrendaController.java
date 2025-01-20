package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaCreateDTO;
import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.service.IPrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private final IPrendaService prendaService;

    public PrendaController(IPrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping
    public ResponseEntity<PrendaDTO> createPrenda(@RequestBody PrendaCreateDTO prenda) {
        return new ResponseEntity<PrendaDTO>(prendaService.create(prenda), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PrendaDTO>> getAllPrendas(@RequestParam(required = false) String name) {
        return new ResponseEntity<List<PrendaDTO>>(prendaService.getAll(name), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<PrendaDTO> getPrendaById(@PathVariable("code") Long code) {
        return new ResponseEntity<PrendaDTO>(prendaService.getPrendaByCode(code),HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<PrendaDTO> updatePrenda(@PathVariable("code") Long code, @RequestBody PrendaCreateDTO prenda) {
        return new ResponseEntity<PrendaDTO>(prendaService.updatePrendaByCode(code, prenda),HttpStatus.CREATED);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deletePrenda(@PathVariable("code") Long code) {
        prendaService.deletePrenda(code);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaDTO>> getPrendasBySize(@PathVariable("size") String size) {
        return new ResponseEntity<List<PrendaDTO>>(prendaService.findByTalle(size),HttpStatus.OK);
    }
}
