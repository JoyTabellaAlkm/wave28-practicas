package com.bootcamp.CodigoMorse.controller;

import com.bootcamp.CodigoMorse.service.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigoMorse")
public class CodigoMorseController {

    @Autowired
    CodigoMorseService codigoMorseService;
    @GetMapping("morseToText")
    public String decodificar(@RequestParam String texto) {
       String traducir= codigoMorseService.traducirMorseATexto(texto);
        return traducir.toString();
    }

    @GetMapping("textToMorse")
    public String codificar (String texto) {
        String codificar = codigoMorseService.traducirTextoAMorse(texto);
        return codificar.toString();
    }
}
