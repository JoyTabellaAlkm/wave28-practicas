package com.mercadolibre.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/greeting/{name}")
    public String greetingWithPathVariable(@PathVariable String name) {
        return new StringBuilder()
                .append("Hola ")
                .append(name)
                .append(". ¿Cómo estás?")
                .toString();
    }

}
