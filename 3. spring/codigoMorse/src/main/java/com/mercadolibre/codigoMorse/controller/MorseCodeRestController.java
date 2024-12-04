package com.mercadolibre.codigoMorse.controller;

import com.mercadolibre.codigoMorse.service.MorseCodeParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseCodeRestController {
    @Autowired
    private MorseCodeParseService morseCodeParseService;

    @GetMapping
    public String morseCodeToText(@RequestParam String morse){
        return morseCodeParseService.convertMorseToText(morse);
    }
}
