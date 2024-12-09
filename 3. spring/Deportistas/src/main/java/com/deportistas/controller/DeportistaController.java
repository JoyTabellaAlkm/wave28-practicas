package com.deportistas.controller;

import com.deportistas.model.DeportistaDTO;
import com.deportistas.model.PersonaDTO;
import com.deportistas.service.DeportistaService;
import com.deportistas.service.IDeportistaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class DeportistaController {

    IDeportistaService deportistaService = new DeportistaService();

    @GetMapping("findSports")
    public String findSports() {
        List<DeportistaDTO> deportesList = deportistaService.findAllSports();
        String result = "";
        for (DeportistaDTO deportistaDTO : deportesList) {
            result += deportistaDTO.getNombre() + " - " + deportistaDTO.getNivel() + "\n";
        }
        return result;
    }
    @GetMapping("findSports/{name}")
    public String findSports(@PathVariable String name) {
        List<DeportistaDTO> deportesList = deportistaService.findByName(name);
        String result = "";
        for (DeportistaDTO deportistaDTO : deportesList) {
            result += deportistaDTO.getNombre() + " - " + deportistaDTO.getNivel() + "\n";
        }
        return result;
    }
    @GetMapping("findSportsPersonas")
    public String findSportsPersons() {
        //return deportistaService.findAllPersons();
        List<PersonaDTO> personasList = deportistaService.findAllPersons();
        String result = "";
        for (PersonaDTO personaDTO : personasList) {
            result += "Nombre: " + personaDTO.getNombre() + " " + personaDTO.getApellido() +
                    " / Edad: " + personaDTO.getEdad() +
                    " / Deportes: " + findSports(personaDTO.getNombre()) + "\n";
        }
        return result;
    }
}