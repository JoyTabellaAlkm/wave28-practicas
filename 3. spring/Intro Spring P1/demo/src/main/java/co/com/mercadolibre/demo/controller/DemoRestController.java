package co.com.mercadolibre.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    @GetMapping("/saludo/{name}")
    public String saludarParam(@PathVariable String name){
        return "Hola "+name;
    }

    @GetMapping("/saludo")
    public String saludarRequestParam(@RequestParam String name){
        return "Hola " + name + ", ¿cómo vas?";
    }
}
