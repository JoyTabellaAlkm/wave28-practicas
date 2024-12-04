package com.morse.controller;

import com.morse.service.MorseConverterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("morse-code")
public class MorseConverterController {


    @GetMapping("morse-to-word/{morse}")
    public Map<String, String> convertMorseToWord(@PathVariable String morse) {
        return Map.of("word", MorseConverterService.convertMorseToWord(morse));
    }

}