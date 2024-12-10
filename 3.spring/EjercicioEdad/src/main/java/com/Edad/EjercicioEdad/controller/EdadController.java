package com.Edad.EjercicioEdad.controller;


import com.Edad.EjercicioEdad.service.impl.EdadServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EdadController {
    EdadServiceImpl service = new EdadServiceImpl();

    @GetMapping("/{dia}/{mes}/{ano}")
    public String calcularEdadPersona(@PathVariable int dia, @PathVariable int mes, @PathVariable int ano){
        return service.calculaEdad(dia, mes, ano );
    }
}
