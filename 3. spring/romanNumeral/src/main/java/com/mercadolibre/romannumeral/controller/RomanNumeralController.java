package com.mercadolibre.romannumeral.controller;

import com.mercadolibre.romannumeral.service.RomanNumeralService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class RomanNumeralController {

    private final RomanNumeralService romanNumeralService;

    public RomanNumeralController(RomanNumeralService romanNumeralService) {
        this.romanNumeralService = romanNumeralService;
    }

    @GetMapping("/{number}")
    public String convertToRoman(@PathVariable Integer number){
        return romanNumeralService.convertToRoman(number);
    }
}
