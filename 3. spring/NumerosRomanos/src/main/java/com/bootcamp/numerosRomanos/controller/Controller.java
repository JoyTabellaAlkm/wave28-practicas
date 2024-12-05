package com.bootcamp.numerosRomanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/{numero}")
    public String numero(@PathVariable String numero){
        return "buenas noches";
    }

    @GetMapping("/")
    public String base(){
        return "buenos dias";
    }
}
