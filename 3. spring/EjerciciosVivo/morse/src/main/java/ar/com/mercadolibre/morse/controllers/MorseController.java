package ar.com.mercadolibre.morse.controllers;

import ar.com.mercadolibre.morse.services.MorseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @GetMapping("/{codigo_morse}")
    public String convertirMorse(@PathVariable String codigo_morse){
        MorseService morseService = new MorseService();
        return morseService.convertirMorse(codigo_morse);
    }
}
