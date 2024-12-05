package ejercicios.mascota.controllers;

import ejercicios.mascota.services.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ejercicios.mascota.dto.requests.PersonaDto;
@RestController
public class PersonaController {

    @Autowired
    private IPersona personaService;

    @PostMapping("/persona")
    public ResponseEntity<?> agregarPersona(@RequestBody PersonaDto personaDto){
    return new ResponseEntity<>(personaService.agregarPersonaDTO(personaDto), HttpStatus.CREATED);
    }
}
