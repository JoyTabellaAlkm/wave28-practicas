package com.Morse.CodigoMorse.Controller;


import com.Morse.CodigoMorse.Services.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigo")
public class CodigoMorseController {

    // URL: http://localhost:8080/codigo/desdeMorse?codigoMorse=--..---.-
    @GetMapping("/desdeMorse")
    public String traducirDesdeMorse(@RequestParam String codigoMorse) {
        return CodigoMorseService.traducirDesdeMorse(codigoMorse);
    }

    // URL: http://localhost:8080/codigo/haciaMorse?textoNormal=--..---.-
    @GetMapping("/haciaMorse")
    public String traducirHaciaMorse(@RequestParam String textoNormal) {
        return CodigoMorseService.traducirHaciaMorse(textoNormal);
    }
}