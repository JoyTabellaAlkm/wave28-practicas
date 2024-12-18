package com.morseExercise.morseTranslatorApi.controller;

import com.morseExercise.morseTranslatorApi.service.IMorseTranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/translate")
public class MorseTranslatorController {

    @Autowired
    IMorseTranslatorService morseTranslatorService;

    @GetMapping("/morse/{morseWord}")
    public String translateWord(@PathVariable String morseWord){
        return morseTranslatorService.translateWord(morseWord).toString();
    }
}
