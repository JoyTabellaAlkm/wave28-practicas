package com.example.codigoMorse.controller;

import com.example.codigoMorse.service.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {

    MorseService morseService = new MorseService();

    @GetMapping("/convertir")
    public String convertirMorseAEspañol(@RequestParam String morse) {
        return morseService.convertirMorseATexto(morse);
    }
}
