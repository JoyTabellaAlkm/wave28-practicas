package com.example.ejerciciocovid.controller;

import com.example.ejerciciocovid.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sintomas")
public class SintomaController {

    @Autowired
    ISintomaService iSintomaService;

    @GetMapping("/findSymptom")
    ResponseEntity<?> getSintomas(){
        return ResponseEntity.ok(iSintomaService.obtenerSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    ResponseEntity<?> getSintoma(@PathVariable String name){
        if(iSintomaService.obtenerSintoma(name) == null){
            return ResponseEntity.status(404).body("No hay ningún síntoma de nombre " + name);
        }
        return ResponseEntity.ok(iSintomaService.obtenerSintoma(name));
    }

    @GetMapping("/findRiskPerson")
    ResponseEntity<?> getPersonasEnRiesgo(){
        return ResponseEntity.ok(iSintomaService.obtenerPersonasDeRiesgo());
    }
}
