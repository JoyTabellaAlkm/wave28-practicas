package com.melibootcamp.empresadeseguros.controller;


import com.melibootcamp.empresadeseguros.entity.Siniestro;
import com.melibootcamp.empresadeseguros.service.SiniestroServiceImpl;
import com.melibootcamp.empresadeseguros.service.interfaces.ISiniestroService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {

    private ISiniestroService siniestroService;

    public SiniestroController(SiniestroServiceImpl siniestroServiceImpl){
        this.siniestroService = siniestroServiceImpl;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getSiniestros(){
        return new ResponseEntity<>(siniestroService.getSiniestros(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveSiniestro(
            @RequestBody Siniestro siniestro)
    {
        return new ResponseEntity<>(siniestroService.saveSiniestro(siniestro), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getSiniestroById(
            @PathVariable long id)
    {
        return new ResponseEntity<>(siniestroService.getSiniestroById(id), HttpStatus.OK);
    }




}
