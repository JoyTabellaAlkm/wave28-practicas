package ar.com.mercadolibre.edadpersona.controllers;

import ar.com.mercadolibre.edadpersona.services.IEdadPersonaService;
import ar.com.mercadolibre.edadpersona.services.impl.EdadPersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class EdadPersonaController {
    @Autowired
    private IEdadPersonaService edadPersonaService;

    @GetMapping("/{day}/{month}/{year}")
    public String devuelveEdad(@PathVariable String day,
                                @PathVariable String month,
                                @PathVariable String year) {
        Integer age = edadPersonaService.convertirFechaAEdad(day,month,year);
        return age == -1 ? "Fecha no valida" : String.valueOf(age);
    }
}
