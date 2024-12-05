package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.domain.Deporte;
import com.bootcamp.deportistas.domain.Persona;
import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.dto.PersonaDTO;
import com.bootcamp.deportistas.mapper.DeporteMapper;
import com.bootcamp.deportistas.mapper.PersonaMapper;
import com.bootcamp.deportistas.service.deporte.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DeporteRestController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        List<Deporte> listaDeportes = deporteService.findAll();
        List<DeporteDTO> listaDeportesDTO = listaDeportes.stream()
                .map(DeporteMapper::mapToDeporteDTO)
                .toList();
        return new ResponseEntity<>(listaDeportesDTO, HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDTO> findSportByName(@PathVariable String name) {
        Optional<Deporte> deporte = deporteService.findByName(name);
        if(deporte.isPresent()) {
            DeporteDTO deporteDTO = DeporteMapper.mapToDeporteDTO(deporte.get());
            return new ResponseEntity<>(deporteDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> findSportsPersons() {
        List<Persona> listaPersona = deporteService.findSportPersons();
        List<PersonaDTO> listaPersonaDTO = listaPersona.stream().map(PersonaMapper::mapToPersonaDTO).toList();
        return new ResponseEntity<>(listaPersonaDTO, HttpStatus.OK);
    }
}
