package org.ejercicios.ejerciciosspring.controller;

import org.ejercicios.ejerciciosspring.service.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @Autowired
    MorseService ms;

    @GetMapping("/morse/{palabra}")
    public String TraducirMorse(@PathVariable String palabra){
        return ms.traducir(palabra);
    }
}