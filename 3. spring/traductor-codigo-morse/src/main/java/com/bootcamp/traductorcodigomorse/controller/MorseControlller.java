package com.bootcamp.traductorcodigomorse.controller;

import com.bootcamp.traductorcodigomorse.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseControlller {
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