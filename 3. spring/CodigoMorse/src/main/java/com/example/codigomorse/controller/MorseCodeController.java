package com.example.codigomorse.controller;

import com.example.codigomorse.service.MorseCodeParseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseCodeController {
    @Autowired
    private MorseCodeParseService morseCodeParseService;

    @GetMapping
    public String morseCodeToText(@RequestParam String morse){

        return morseCodeParseService.convertMorseCodeToText(morse);
    }

}
