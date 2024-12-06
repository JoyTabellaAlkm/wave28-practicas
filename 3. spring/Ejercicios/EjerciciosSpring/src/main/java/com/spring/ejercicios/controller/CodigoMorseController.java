package com.spring.ejercicios.controller;

import com.spring.ejercicios.service.impl.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    CodigoMorseService morseService = new CodigoMorseService();

    @GetMapping("/convertir")
    public String convertirMorseAEspañol(@RequestParam String morse) {
        return morseService.convertirMorseATexto(morse);
    }
}
