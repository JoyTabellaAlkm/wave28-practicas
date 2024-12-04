package com.ar.mercadolibre.codigomorse.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ar.mercadolibre.codigomorse.services.IMorseTraductorService;
import com.ar.mercadolibre.codigomorse.services.MorseTraductorServiceImpl;



@RestController
@RequestMapping("/traductor")
public class MorseTraductorController {

    private IMorseTraductorService servicio;

    public MorseTraductorController() {
        this.servicio = new MorseTraductorServiceImpl();
    }

    @GetMapping("/codigo/{codigoMorse}")
    public String devolverPalabra(@PathVariable String codigoMorse) {
        return servicio.devolverPalabra(codigoMorse);
    }
}
