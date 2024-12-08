package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.service.impl.DeporteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class DeportistaController {

    @Autowired
    private DeporteServiceImpl iDeporteService;

    @GetMapping("/all")
    public ResponseEntity<?> findSports(){
        return ResponseEntity.ok(iDeporteService.findAllSports());
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> findSportsByName(@RequestParam String deporte){
        return iDeporteService.findSportByName(deporte);
    }

    @GetMapping("/buscarDeportista")
    public ResponseEntity<?> findSportsPerson(){
        return ResponseEntity.ok(iDeporteService.findSportsPerson());
    }
}
