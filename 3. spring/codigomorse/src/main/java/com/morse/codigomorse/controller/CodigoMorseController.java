package com.morse.codigomorse.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.morse.codigomorse.service.CodigoMorseService;

@RestController
public class CodigoMorseController {

    private static CodigoMorseService codigoMorseService = new CodigoMorseService();

    @GetMapping("/{morse}")
    public String convertirCodigoMorse(@PathVariable String morse){
        return codigoMorseService.convertirMensaje(morse);
    }
}
