package com.codigoMorse.morseALetras.controller;

import com.codigoMorse.morseALetras.service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class CodigoMorseController {
    private final CodigoMorseService service = new CodigoMorseService();

    @GetMapping("/{mensaje}")
    public String descifrarMorse(@PathVariable String mensaje){
        return service.descifrarMensaje(mensaje);
    }
}
