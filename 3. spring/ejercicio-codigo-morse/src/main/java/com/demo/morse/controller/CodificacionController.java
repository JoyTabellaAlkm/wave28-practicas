package com.demo.morse.controller;

import com.demo.morse.service.CodificacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codificacion")
public class CodificacionController {

    @GetMapping("/decodificar/{codigo}")
    public ResponseEntity<java.lang.String> decodificar(@PathVariable String codigo) {
        return ResponseEntity.ok(CodificacionService.decodificar(codigo));
    }

    @GetMapping("/codificar/{frase}")
    public ResponseEntity<java.lang.String> codificar(@PathVariable String frase) {
        return ResponseEntity.ok(CodificacionService.codificar(frase));
    }
}
