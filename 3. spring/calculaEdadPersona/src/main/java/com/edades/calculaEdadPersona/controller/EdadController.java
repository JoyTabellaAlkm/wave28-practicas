package com.edades.calculaEdadPersona.controller;

import com.edades.calculaEdadPersona.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class EdadController {
    EdadService service = new EdadService();

    @GetMapping("/{dia}/{mes}/{ano}")
    public String calcularEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return service.calculaEdad(dia, mes, ano );
    }
}
