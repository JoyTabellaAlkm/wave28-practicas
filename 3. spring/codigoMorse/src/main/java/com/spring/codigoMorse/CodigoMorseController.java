package com.spring.codigoMorse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {

    @Autowired
    private CodigoMorseService service;

    @GetMapping("/{mensaje}")
    public String decodificar(@PathVariable String mensaje){
        System.out.println(mensaje);
        String respuesta = service.decodificar(mensaje);
        return "El mensaje decodificado es " + respuesta;
    }
}
