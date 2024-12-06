package com.bootcamp.starWars.controller;

import com.bootcamp.starWars.dto.PersonajeDTO;
import com.bootcamp.starWars.model.Personaje;
import com.bootcamp.starWars.service.StarWarsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    @Autowired
    StarWarsImpl starWars;

    @GetMapping("/{name}")
    public List<PersonajeDTO> buscarPersonajesPorNombre(@PathVariable String name) {
        return starWars.buscarPersonajesPorNombre(name);
    }
}
