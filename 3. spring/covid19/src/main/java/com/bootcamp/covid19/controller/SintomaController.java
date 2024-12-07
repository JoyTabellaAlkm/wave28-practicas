package com.bootcamp.covid19.controller;

import com.bootcamp.covid19.dto.SintomaDTO;
import com.bootcamp.covid19.service.impl.SintomaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sintoma")
public class SintomaController {

    @Autowired
    SintomaServiceImpl sintomaServiceImpl;
    @PostMapping("/agregarSintoma")
    public ResponseEntity<?> agregarSintoma(@RequestBody SintomaDTO sintomaDTO){
        return ResponseEntity.ok(sintomaServiceImpl.agregarSintoma(sintomaDTO));
    }

    @GetMapping("/obtenerSintoma/{sintoma}")
    public ResponseEntity<?> obtenerSintomas(@PathVariable String sintoma){
        return ResponseEntity.ok(sintomaServiceImpl.obtenersintonas(sintoma));
    }
}
