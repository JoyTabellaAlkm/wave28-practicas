package com.example.edad_persona.Controller;

import com.example.edad_persona.Service.IEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    // Declaración del SERVICE de FORMA CORRECTA (V)
    private final IEdadService edadService;

    @Autowired
    public EdadController(IEdadService edadService) {
        this.edadService = edadService;
    }
    // Declaración del SERVICE de FORMA INCORRECTA (X)
//    @Autowired
//    private EdadService edadService;

    @GetMapping("/{day}/{month}/{year}")
    public String calcularEdad(@PathVariable int day, @PathVariable int month,@PathVariable int year){
        long edad = edadService.calcularEdad(day, month, year);
        return edad == -1 ? "Fecha no valida" : Long.toString(edad);
    }
}
