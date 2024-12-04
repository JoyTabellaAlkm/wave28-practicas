package com.bootcamp.Morse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {

    @Autowired
    private MorseService service;

    @GetMapping("/{mensaje}")
    public String decodificar(@PathVariable String mensaje){
        System.out.println(mensaje);
        String respuesta = service.decodificar(mensaje);
        return "El mensaje decodificado es " + respuesta;
    }
}
