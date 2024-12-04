package com.example.codigomorse.controller;

import com.example.codigomorse.servicio.TraducirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/morse")
public class MorseController {
    private TraducirService service = new TraducirService();

    @GetMapping("/texto")
    public String traducirCodigo(@RequestParam String codigo) {

        return service.separarPalabras(codigo).stream().collect(Collectors.joining(" "));
    }


}
