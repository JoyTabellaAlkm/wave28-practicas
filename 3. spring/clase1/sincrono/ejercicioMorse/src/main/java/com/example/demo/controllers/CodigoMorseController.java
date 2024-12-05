package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.CodigoMorseService;

@RestController
@RequestMapping("/codigo")
public class CodigoMorseController {
    @GetMapping("/desdeMorse")
    public String traducirDesdeMorse(@RequestParam String codigoMorse) {
        return CodigoMorseService.traducirDesdeMorse(codigoMorse);
    }
    @GetMapping("/haciaMorse")
    public String traducirHaciaMorse(@RequestParam String textoNormal) {
        return CodigoMorseService.traducirHaciaMorse(textoNormal);
    }
}
