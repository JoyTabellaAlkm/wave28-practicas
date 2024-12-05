package co.mercadolibre.morse.controller;

import co.mercadolibre.morse.service.MorseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class MorseController {
    MorseService ms = new MorseService();

    @GetMapping("/encriptar")
    public String encriptarMorse(@RequestParam String text){
        return ms.stringToMorse(text);
    }

    @GetMapping("/desencriptar")
    public String desencriptarMorse(@RequestParam String morse){
        return ms.morseToString(morse);
    }
}
