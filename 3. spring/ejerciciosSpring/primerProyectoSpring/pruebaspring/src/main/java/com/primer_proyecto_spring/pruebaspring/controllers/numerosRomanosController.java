package com.primer_proyecto_spring.pruebaspring.controllers;

import com.primer_proyecto_spring.pruebaspring.services.InumeroRomanoServiceImpl;
import com.primer_proyecto_spring.pruebaspring.services.MorseService;
import com.primer_proyecto_spring.pruebaspring.services.NumeroRomanoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class numerosRomanosController {

    NumeroRomanoService numeroRomanoService = new InumeroRomanoServiceImpl();
    private final MorseService morseService;

    public numerosRomanosController(MorseService morseService) {
        this.morseService = morseService;
    }

    @GetMapping("/numero")
    public String recibirNumero(@RequestParam(name = "numero") int numero) {
        System.out.println("El número recibido es: " + numero) ;
        return numeroRomanoService.convertirNumero(numero);
    }

    @GetMapping("/convertir")
    public String convertirMorseATexto(@RequestParam("morse") String morse) {
        String texto = morseService.morseToText(morse);
        return "El texto correspondiente al código Morse '" + morse + "' es: " + texto;
    }

}
