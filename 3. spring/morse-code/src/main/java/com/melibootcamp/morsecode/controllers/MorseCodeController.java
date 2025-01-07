package com.melibootcamp.morsecode.controllers;

import com.melibootcamp.morsecode.service.MorseCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/morseCode")
public class MorseCodeController {

    private MorseCodeService morseCodeService;

    public MorseCodeController(MorseCodeService morseCodeService){
        this.morseCodeService = morseCodeService;
    }

    @GetMapping("/decoder/{morseCode}")
    public String decodeMorseCode(@PathVariable("morseCode") String morseCode){
        String decodedText = morseCodeService.convertMorseToLatin(morseCode);
        return decodedText;
    }



}
