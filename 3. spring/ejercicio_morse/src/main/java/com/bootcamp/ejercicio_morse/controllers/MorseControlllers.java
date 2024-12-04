package com.bootcamp.ejercicio_morse.controllers;

import com.bootcamp.ejercicio_morse.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseControlllers {
    @Autowired
    private MorseService morseService;

    @GetMapping("morse")
    public String getTexto(@RequestParam String morse) {

        return morseService.morseATexto(morse);
    }
    @GetMapping("texto")
    public String getMorse(@RequestParam String texto) {

        return morseService.textoAMorse(texto.toUpperCase());
    }


}
