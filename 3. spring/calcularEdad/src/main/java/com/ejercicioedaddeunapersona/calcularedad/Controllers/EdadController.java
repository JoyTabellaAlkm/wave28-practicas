package com.ejercicioedaddeunapersona.calcularedad.Controllers;

import com.ejercicioedaddeunapersona.calcularedad.Services.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    EdadService servicio = new EdadService();

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer getEdad(@PathVariable int dia,@PathVariable int mes,@PathVariable int ano){
        return servicio.calcularEdad(dia, mes, ano);
    }
}
