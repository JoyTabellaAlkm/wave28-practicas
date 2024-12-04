package com.morse.codigomorse.controller;


import com.morse.codigomorse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodigoMorseController {
    private final CodigoMorseService codigoMorseService = new CodigoMorseService();

    @GetMapping("/{morse}")
    public String convertirAMorse(@PathVariable String morse){
        return codigoMorseService.convertirMensaje(morse);
    }
}
