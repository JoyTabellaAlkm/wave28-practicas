package com.mercadolibre.obteneredad;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadRestController {
    public Integer edad;
    @GetMapping(path = "{dia}/{mes}/{anio}")
    public Integer obtenerEdad(@PathVariable Integer dia,
                                     @PathVariable Integer mes,
                                     @PathVariable Integer anio){


        return 5;

    }

}
