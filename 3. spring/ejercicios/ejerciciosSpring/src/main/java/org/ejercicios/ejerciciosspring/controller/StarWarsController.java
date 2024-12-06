package org.ejercicios.ejerciciosspring.controller;

import org.ejercicios.ejerciciosspring.dto.PersonajeDTO;
import org.ejercicios.ejerciciosspring.service.StarWarsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

        @Autowired
        StarWarsImpl starWars;

        @GetMapping("personaje/{name}")
        public List<PersonajeDTO> buscarPersonajesPorNombre(@PathVariable String name) {
            return starWars.buscarPersonajesPorNombre(name);
        }
}
