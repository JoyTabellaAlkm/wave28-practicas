package com.bootcamp.obtenerEdad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EdadController {

    @Autowired
    private  EdadServicio edadServicio;


    @GetMapping("/{dia}/{mes}/{año}")
    public int obtenerEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int año){

        int edad = edadServicio.obetenerEdad(año,mes,dia);
        return  edad;

    }


}
