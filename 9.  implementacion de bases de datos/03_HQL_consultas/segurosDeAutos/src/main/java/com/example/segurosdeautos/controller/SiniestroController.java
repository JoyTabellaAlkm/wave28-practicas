package com.example.segurosdeautos.controller;

import com.example.segurosdeautos.dto.request.SiniestroRequestDto;
import com.example.segurosdeautos.dto.response.SiniestroResponseDto;
import com.example.segurosdeautos.service.ISiniestroService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {

    private final ISiniestroService siniestroService;

    public SiniestroController(ISiniestroService siniestroService){
        this.siniestroService = siniestroService;
    }

    @PostMapping("/new")
    @Transactional
    public ResponseEntity<SiniestroResponseDto> crearSiniestro(@RequestBody SiniestroRequestDto siniestro){
        return new ResponseEntity<>(siniestroService.crearSiniestro(siniestro), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<SiniestroResponseDto>> obtenerTodosLosSiniestros(){
        return new ResponseEntity<>(siniestroService.obtenerTodosLosSiniestros(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerSiniestroPorId(@PathVariable Long id){
        return new ResponseEntity<>(siniestroService.obtenerSiniestroPorId(id), HttpStatus.OK);
    }
}
