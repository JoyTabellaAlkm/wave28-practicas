package com.mercadolibre.morse_code.controller;

import com.mercadolibre.morse_code.service.ConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("morse-code")
public class ConverterController {


    @GetMapping("morse-to-word/{morse}")
    public Map<String, String> convertMorseToWord(@PathVariable String morse) {
        return Map.of("word", ConverterService.convertMorseToWord(morse));
    }

}
