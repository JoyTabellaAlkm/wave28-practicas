package co.mercadolibre.calculoedad.controller;

import co.mercadolibre.calculoedad.service.EdadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edad")
public class EdadController {

    EdadService es = new EdadService();
    @GetMapping("/{dia}/{mes}/{anio}")
    public String calculoEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio){
        return es.calcularEdad(dia, mes, anio);
    }

}
