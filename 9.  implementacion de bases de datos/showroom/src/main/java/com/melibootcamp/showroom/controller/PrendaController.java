package com.melibootcamp.showroom.controller;


import com.melibootcamp.showroom.dto.PrendaDto;
import com.melibootcamp.showroom.entity.Prenda;
import com.melibootcamp.showroom.service.PrendaService;
import com.melibootcamp.showroom.service.PrendaServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private PrendaService prendaService;

    public PrendaController(PrendaServiceImpl prendaServiceImpl){
        this.prendaService = prendaServiceImpl;
    }

    @GetMapping
    public ResponseEntity<?> getPrendas(){
        return new ResponseEntity<>(prendaService.getPrendas(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getPrendaById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(prendaService.getPrendaById(id), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getPrendaByTalle(
            @PathVariable String size)
    {
        return new ResponseEntity<>(prendaService.getPrendaBySize(size), HttpStatus.OK);
    }

    @GetMapping("/pattern")
    public ResponseEntity<?> getPrendaByPatternOnTitle(
            @RequestParam String name)
    {
        return new ResponseEntity<>(prendaService.getPrendaByPatternOnTitle(name), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> savePrenda(
            @RequestBody PrendaDto prenda)
    {
        return new ResponseEntity<>(prendaService.savePrenda(prenda), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePrenda(
            @PathVariable long id)
    {
        return new ResponseEntity<>(prendaService.deletePrenda(id), HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updatePrenda(
            @RequestBody PrendaDto prenda, @PathVariable long id)
    {
        return new ResponseEntity<>(prendaService.updatePrenda(id, prenda), HttpStatus.OK);
    }



    /*
    @PostMapping("/local-date")
    public void localDate(@RequestParam("localDate")
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
        // ...
    }
    */

}
