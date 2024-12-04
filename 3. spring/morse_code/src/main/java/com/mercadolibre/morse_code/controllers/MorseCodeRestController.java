package com.mercadolibre.morse_code.controllers;

import com.mercadolibre.morse_code.services.MorseCodeParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class MorseCodeRestController {
    private MorseCodeParseService morseCodeParseService;

    public MorseCodeRestController(@Autowired MorseCodeParseService morseCodeParseService) {
        this.morseCodeParseService = morseCodeParseService;
    }

    @GetMapping("morse-to-text")
    public String toLetters(@RequestParam String morse) {
        return morseCodeParseService.parseMorseToText(morse);
    }
}
