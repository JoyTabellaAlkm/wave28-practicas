package com.mercadolibre.ejercicioseguroautos.controller;

import com.mercadolibre.ejercicioseguroautos.dto.SiniestroDTO;
import com.mercadolibre.ejercicioseguroautos.dto.VehiculoDTO;
import com.mercadolibre.ejercicioseguroautos.service.SiniestroServiceImpl;
import com.mercadolibre.ejercicioseguroautos.service.VehiculoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siniestros")
public class SiniestroController {

    private final SiniestroServiceImpl siniestroServiceImpl;

    public SiniestroController(SiniestroServiceImpl siniestroServiceImpl){
        this.siniestroServiceImpl = siniestroServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<List<SiniestroDTO>> getAllSiniestros(){
        return ResponseEntity.ok(siniestroServiceImpl.getAllSiniestros());
    }

    @PostMapping("")
    public ResponseEntity<SiniestroDTO> saveSiniestro(@RequestBody SiniestroDTO siniestroDTO){
        return ResponseEntity.ok(siniestroServiceImpl.saveSiniestro(siniestroDTO));
    }

}
