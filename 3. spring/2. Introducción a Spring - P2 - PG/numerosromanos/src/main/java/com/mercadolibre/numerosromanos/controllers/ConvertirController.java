package com.mercadolibre.numerosromanos.controllers;

import com.mercadolibre.numerosromanos.services.ConvertirService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("convertir")
public class ConvertirController {

    private ConvertirService convertirService;

    public void ConvertirService(ConvertirService convertirService){
        this.convertirService = convertirService;
    }

    @GetMapping("decimal-romano/{numeroDecimal}")
    public String decimalARomano(@PathVariable int numeroDecimal){
        convertirService.
    }
}
