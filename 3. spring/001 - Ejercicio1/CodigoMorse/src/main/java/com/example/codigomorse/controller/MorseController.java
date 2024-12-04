package com.example.codigomorse.controller;

import com.example.codigomorse.servicio.TraducirService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/morse")
public class MorseController {
    private TraducirService service = new TraducirService();

    @GetMapping("/decodificar")
    public String decodificarCodigo(@RequestParam String codigo) {

        return service.decodificarPalabras(codigo).stream().collect(Collectors.joining(" "));
    }

    @GetMapping("/codificar")
    public String traducirTexto(@RequestParam String texto){
        return service.codificarPalabras(texto.toUpperCase());
    }


}
