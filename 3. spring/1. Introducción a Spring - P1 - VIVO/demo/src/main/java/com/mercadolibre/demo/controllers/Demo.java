package com.mercadolibre.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("demo")
public class Demo {

    // metodo get normal
    @GetMapping("")
    public String holaMundo(){
        return "Hola mundo";
    }

    // usando path variable
    @GetMapping("/saludo/{name}")
    public String saludarConPathVariable(@PathVariable String name){
        return "Hola, " + name + "!";
    }

    // usando query param, si hay que usar mas de uno, se separan por `,`
    // (@RequestParam String nombre, @RequestParam String apellido)
    @GetMapping("/saludo")
    public String saludarConQueryParam(@RequestParam String nombre){
        return "Hola, con queryParam: " + nombre + ".";
    }
}
