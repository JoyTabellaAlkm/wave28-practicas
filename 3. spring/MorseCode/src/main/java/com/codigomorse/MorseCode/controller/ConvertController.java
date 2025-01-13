package com.codigomorse.MorseCode.controller;

import com.codigomorse.MorseCode.service.ConvertService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/morsecode")
public class ConvertController {

    @GetMapping("/{morse}")
    public Map<String, String> convertMorseWord(@PathVariable String morse){
        return Map.of("word", ConvertService.convertMorseToWord(morse));
    }
}
