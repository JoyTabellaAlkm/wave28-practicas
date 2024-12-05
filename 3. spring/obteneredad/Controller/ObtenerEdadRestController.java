package com.mercadolibre.obteneredad.Controller;


import com.mercadolibre.obteneredad.Service.IObtenerEdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObtenerEdadRestController {

    @Autowired
    IObtenerEdadService obtenerEdadService;

    @GetMapping("{dia}/{mes}/{anio}")
    public String edad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        int edad = obtenerEdadService.CalculoEdad(dia, mes, anio);

        if (edad == -1){
            return "Fecha Invalida";
        }else {
            return String.valueOf(edad);
        }
    }
}
