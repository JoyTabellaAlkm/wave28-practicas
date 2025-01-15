package com.example.showroom.controller;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.model.Prenda;
import com.example.showroom.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class PrendaController {

    @Autowired
    private IPrendaService prendaService;

    @PostMapping()
    public Prenda savePrenda(@RequestBody Prenda prenda) {
        return prendaService.savePrenda(prenda);
    }

    @GetMapping("")
    public List<Prenda> findAll() {
        return prendaService.findAllPrendas();
    }

    @GetMapping("/{code}")
    public Prenda findByCode(@PathVariable Long code){
        return prendaService.findPrendaById(code);
    }

    @PutMapping("/{code}")
    public Prenda updatePrenda(@RequestBody Prenda prenda, @PathVariable Long code) {
        return prendaService.updatePrendaById(prenda, code);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageDto> deletePrenda(@PathVariable Long code) {
        return new ResponseEntity<>(prendaService.deletePrenda(code), HttpStatus.OK) ;
    }

    @GetMapping("/size/{talle}")
    public List<Prenda> findByTalle(@PathVariable String talle){
        return prendaService.findByTalle(talle);
    }








}
