package com.edadpersona.edaddeunapersona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.edadpersona.edaddeunapersona.service.ObtenerEdadService;

@RestController
public class ObtenerEdadController {

    @Autowired
    ObtenerEdadService obteneredad;

    @GetMapping("edad/{day}/{month}/{year}")
    public int getAge(@PathVariable int day,@PathVariable int month,@PathVariable int year){
        return obteneredad.calcularEdad(day, month, year);
    }
}
