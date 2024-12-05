package com.example.ejerciciodeportistas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonasController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaConDeporteDTO>> listarPersonasConDeportes(){
        List<PersonaConDeporteDTO> listaPersonasConDeporte = new ArrayList<>();
        List<Persona> personas = personaService.listarPersonas();
        for (Persona persona: personas) {
            String nombrePersona = persona.getNombre();
            String apellidoPersona = persona.getApellido();
            String nombreDeporte = persona.getDeporte().getNombre();
            PersonaConDeporteDTO personaConDeporte =new PersonaConDeporteDTO(nombrePersona,apellidoPersona, nombreDeporte);
            listaPersonasConDeporte.add(personaConDeporte);
        }
        return ResponseEntity.ok(listaPersonasConDeporte);
    }
}
