package com.miprimerproyecto.pruebaspring.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    // Localhost:8080/demo/saludo/{nombre}
    @GetMapping("/saludo/{name}")
    public String saludarConPathVariable(@PathVariable String name){
        return "Hola: " + name;
    }

    // localhost:8080/demo/saludo?nombre=Leandro
    @GetMapping("/saludo")
    public String saludarConRequestParam(@RequestParam String name){
        return "Hola con query param: " + name;
    }
}
