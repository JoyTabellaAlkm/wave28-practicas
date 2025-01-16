package com.example.showroom.controller;

import com.example.showroom.dto.PrendaDto;
import com.example.showroom.service.IPrendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    @Autowired
    private IPrendaService iPrendaService;

    // Crear una nueva prenda.
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(iPrendaService.createPrenda(prendaDto), HttpStatus.CREATED);
    }

    // Devolver todas las prenda
    // Buscar todas las prendas por nombre
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(required = false) String name ){
        if (name != null ) return new ResponseEntity<>(iPrendaService.getPrendasByName(name), HttpStatus.OK);
        return new ResponseEntity<>(iPrendaService.getAllPrendas(), HttpStatus.OK);
    }

    //Devolver una prenda en particular
    @GetMapping("/{code}")
    public ResponseEntity<?> findByCode(@PathVariable("code") Long codigo){
        return new ResponseEntity<>(iPrendaService.getPrendaByCodigo(codigo), HttpStatus.OK);
    }

    // Actualizar una prenda en particular
    @PutMapping("/{code}")
    public ResponseEntity<?> update(@PathVariable("code") Long codigo, @RequestBody PrendaDto prendaDto){
        return new ResponseEntity<>(iPrendaService.updatePrenda(prendaDto,codigo), HttpStatus.OK);
    }

    // Eliminar una prenda en particular
    @DeleteMapping("/{code}")
    public ResponseEntity<?> delete(@PathVariable("code") Long codigo){
        return new ResponseEntity<>(iPrendaService.deletePrenda(codigo), HttpStatus.NO_CONTENT);
    }

    // Traer todas las prendas de un determinado talle
    @GetMapping("/size/{size}")
    public ResponseEntity<?> getAllPrendasOfTalla(@PathVariable("size") String talla) {
        return ResponseEntity.ok(iPrendaService.getPrendasByTalla(talla));
    }

}
