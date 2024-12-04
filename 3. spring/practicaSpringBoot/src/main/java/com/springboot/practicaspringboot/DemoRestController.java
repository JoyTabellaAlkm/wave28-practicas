package com.springboot.practicaspringboot;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoRestController {
    @GetMapping("/saludo/{name}")

    public String saludarConPathVariable(@PathVariable String name) {
        return " Hola : " + name;
    }

    @GetMapping("/saludo")

    public String saludarConRequestParam(@RequestParam String name) {
        return " Hola con query param : " + name;
    }

}