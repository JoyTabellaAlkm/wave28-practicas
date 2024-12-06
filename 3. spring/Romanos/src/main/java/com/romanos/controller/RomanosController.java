package com.romanos.controller;

import com.romanos.service.RomanosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RomanosController {
    @GetMapping("{number}")
    public String convertirANumeroRomano(@PathVariable int number) {
        return RomanosService.convertirANumeroRomano(number);
    }

}