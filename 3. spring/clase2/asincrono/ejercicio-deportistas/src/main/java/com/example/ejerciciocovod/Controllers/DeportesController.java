package com.example.ejerciciocovod.Controllers;

import com.example.ejerciciocovod.Clases.Deporte;
import com.example.ejerciciocovod.Clases.PersonaDeportistaDTO;
import com.example.ejerciciocovod.Interfaces.IDeportesService;
import com.example.ejerciciocovod.Services.DeportesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DeportesController {


    private IDeportesService iDeportesService = new DeportesServiceImpl();


    @GetMapping(path = "/findSports")
    ResponseEntity<List<Deporte>> getDeportes() {
        try {
            List<Deporte> deportes = iDeportesService.traerDeportes();
            return ResponseEntity.ok(deportes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @GetMapping(path = "/findSport/{name}")
    ResponseEntity<?> getDeporte(@PathVariable String name) {
        Optional<Deporte> deporte = iDeportesService.traerDeporte(name);
        if (iDeportesService.traerDeporte(name).equals(null)) {
            return ResponseEntity.badRequest().body("No hay ningún deporte con ese nombre");
        }
        return ResponseEntity.ok(deporte.orElse(null));
    }

    @GetMapping(path = "/findSportsPersons")
    ResponseEntity<List<PersonaDeportistaDTO>> getPersonasDeportistas() {
        List<PersonaDeportistaDTO> deportistas = iDeportesService.traerDeportistas();
        if (deportistas.size()>0){
            return ResponseEntity.ok(deportistas);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
