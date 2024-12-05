package com.meli.morseapplication.controllers;

import com.meli.morseapplication.services.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @GetMapping("/{codigo_morse}")
    public String convertirMorse(@PathVariable String codigo_morse){
        MorseService morseService = new MorseService();
        return morseService.convertirMorse(codigo_morse);
    }
}