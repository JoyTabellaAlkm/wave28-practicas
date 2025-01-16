package org.example.ejercicio_practico_opcional.controller;

import org.example.ejercicio_practico_opcional.dto.PrendaDTO;
import org.example.ejercicio_practico_opcional.service.PrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    @Autowired
    PrendaService prendaService;

    @GetMapping
    ResponseEntity<List<PrendaDTO>> findAll() {
        return new ResponseEntity<>(prendaService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PrendaDTO> addPrenda(@RequestBody PrendaDTO prendaDTO) {
        return new ResponseEntity<>(prendaService.addPrenda(prendaDTO), HttpStatus.CREATED);
    }

    @GetMapping("{codigo}")
    ResponseEntity<PrendaDTO> findPrendaByCodigo(@PathVariable Long codigo) {
        return new ResponseEntity<>(prendaService.findByCodigo(codigo), HttpStatus.OK);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PrendaDTO> updatePrenda(
            @PathVariable Long codigo,
            @RequestBody PrendaDTO prendaDTO) {
        return new ResponseEntity<>(prendaService.updatePrenda(codigo, prendaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<String> deletePrenda(@PathVariable Long codigo) {
        prendaService.deletePrenda(codigo);

        return new ResponseEntity<>("Se elimino la prenda con codigo: " + codigo, HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<List<PrendaDTO>> getPrendasByTalle(@PathVariable String size) {
        List<PrendaDTO> prendas = prendaService.findByTalle(size);
        return ResponseEntity.ok(prendas);
    }

    @GetMapping(params = "name") // Filtra la solicitud para que sólo se llame si 'name' está presente
    public ResponseEntity<List<PrendaDTO>> getPrendasByName(@RequestParam String name) {
        List<PrendaDTO> prendas = prendaService.findByName(name);
        return ResponseEntity.ok(prendas);
    }
}
