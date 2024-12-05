package com.miprimerproyecto.pruebaspring;

import org.springframework.web.bind.annotation.RestController;

@RestController
@org.springframework.web.bind.annotation.RequestMapping("/demo")
public class DemoRestController {

    // localhost:8080/demo/saludo/{nombre}
    @org.springframework.web.bind.annotation.GetMapping("/saludo/{name}")
    public String saludarConPathVariable(@org.springframework.web.bind.annotation.PathVariable String name) {
        return "Hola: " + name;
    }

    // localhost:8080/demo/saludo?name=Leandro
    @org.springframework.web.bind.annotation.GetMapping("/saludo")
    public String saludarConRequestParam(@org.springframework.web.bind.annotation.RequestParam String name) {
        return "Hola con query param: " + name;
    }
}
