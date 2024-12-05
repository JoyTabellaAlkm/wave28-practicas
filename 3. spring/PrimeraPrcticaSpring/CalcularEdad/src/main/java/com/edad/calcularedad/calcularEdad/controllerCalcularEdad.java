package com.edad.calcularedad.calcularEdad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular")

public class controllerCalcularEdad {

    private serviceCalcularEdad calcularEdadService = new serviceCalcularEdad();

    @GetMapping("/edad")
    public String edad(@RequestParam String fecha){
        System.out.println("entró");
        return calcularEdadService.calcularEdad(fecha);
    }
}
