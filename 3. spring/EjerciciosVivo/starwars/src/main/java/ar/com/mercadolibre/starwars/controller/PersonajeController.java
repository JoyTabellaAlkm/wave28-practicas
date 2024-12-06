package ar.com.mercadolibre.starwars.controller;

import ar.com.mercadolibre.starwars.model.Personaje;
import ar.com.mercadolibre.starwars.service.IPersonajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personajes")
public class PersonajeController {
    @Autowired
    private IPersonajesService personajeService;

    @GetMapping()
    public ResponseEntity<?> findByName(@RequestParam String name){
        List<Personaje> lista = personajeService.findByName(name);

        return ResponseEntity.ok(lista);
    }
}
