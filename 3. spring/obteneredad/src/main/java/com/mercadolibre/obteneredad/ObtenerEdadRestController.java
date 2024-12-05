package com.mercadolibre.obteneredad;


import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.time.Month;
import java.time.LocalDate;

@RestController
public class ObtenerEdadRestController {
    public Integer edad;
    @GetMapping("{dia}/{mes}/{anio}")
    public Integer edad(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio){
        Integer concatenarMesDia = mes * 100 + dia;
        Integer concatenarMesDiaHoy = LocalDate.now().getMonth().getValue() * 100 + LocalDate.now().getDayOfMonth();

        if(concatenarMesDia > concatenarMesDiaHoy) {
            return LocalDate.now().getYear() - anio - 1;
        } else {
            return LocalDate.now().getYear() - anio;
        }

    }
}
