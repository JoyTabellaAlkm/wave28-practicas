package com.ejerciciomorse.ejercicio_morse.Controllers;

import com.ejerciciomorse.ejercicio_morse.Services.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    private MorseService morseService = new MorseService();

    @GetMapping("morse")
    public String getTexto(@RequestParam String morse) {

        return morseService.morseATexto(morse);
    }
    @GetMapping("texto")
    public String getMorse(@RequestParam String texto) {

        return morseService.textoAMorse(texto.toUpperCase());
    }


}
