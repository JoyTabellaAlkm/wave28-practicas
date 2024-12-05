package com.morse.codigomorse.controller;


import com.morse.codigomorse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    private final CodigoMorseService codigoMorseService = new CodigoMorseService();

    @GetMapping("convertirALetras/{morse}")
    public String convertirMorse(@PathVariable String morse){
        return codigoMorseService.convertirMensajeALetras(morse);
    }

    @GetMapping("convertirAMorse/{mensaje}")
    public String convertirLetras(@PathVariable String mensaje){
        return codigoMorseService.convertirMensajeAMorse(mensaje);
    }
}
