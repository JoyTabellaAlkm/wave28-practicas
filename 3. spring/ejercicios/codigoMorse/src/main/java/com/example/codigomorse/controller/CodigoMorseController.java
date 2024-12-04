package com.example.codigomorse.controller;

import com.example.codigomorse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    CodigoMorseService servicioCodigoMorse = new CodigoMorseService();
    @GetMapping("/convertir")
    public String convertirMorseAEspañol(@RequestParam String morse) {
        return servicioCodigoMorse.convertirMorseATexto(morse);
    }
}
