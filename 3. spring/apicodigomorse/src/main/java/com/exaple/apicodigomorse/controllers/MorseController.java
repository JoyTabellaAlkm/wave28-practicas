package com.exaple.apicodigomorse.controllers;

import com.exaple.apicodigomorse.services.MorseService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/morseCode")
public class MorseController {
    @GetMapping("morse-to-word/{morse}")
    public Map<String, String> convertMorseToWord(@PathVariable String morse) {
        return Map.of("word", MorseService.convertMorseToWord(morse));
    }
}
