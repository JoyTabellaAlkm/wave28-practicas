package Ejercicios.traduccir_morse.controllers;

import Ejercicios.traduccir_morse.services.CodigoMorseService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("codigoMorse")
public class EjercicioCodigoMorseController {

    public CodigoMorseService _servicio;
    public EjercicioCodigoMorseController() {
        this._servicio = new CodigoMorseService();
    }

    @GetMapping("/traducirLetraAMorse")
    public String traducirLetraAMorse(@RequestParam String oracion) {
        return "Código Morse: " + this._servicio.oracionAMorse(oracion);
    }


    @GetMapping("/traducirMorseALetra")
    public String traducirMorseALetra(@RequestParam String morse) {
        return "Traducción: " + this._servicio.morseAOracion(morse);

    }
}
