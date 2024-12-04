package com.practica.primerapracticaspring;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class RestControllerPractica {

    @GetMapping("/saludo/{name}")
    public String saluarVariable(@PathVariable String name){
        return "Hola " + name;
    }

    @GetMapping("saludo2")
    public  String saludarQuery(@RequestParam String apellido){return  "Hola" + apellido;}
}
