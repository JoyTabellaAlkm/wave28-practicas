package com.calcularedad.calcularedad.controller;

import com.calcularedad.calcularedad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return EdadService.calcularEdad(dia,mes,anio);
    }

    @GetMapping("/")
    public String base(){
        return "buenos dias";
    }

}
