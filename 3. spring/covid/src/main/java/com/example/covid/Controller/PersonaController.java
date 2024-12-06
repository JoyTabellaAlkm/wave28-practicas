package com.example.covid.Controller;

import com.example.covid.DTO.PersonaDTO;
import com.example.covid.DTO.PersonaXSintomaDTO;
import com.example.covid.DTO.SintomaDTO;
import com.example.covid.Model.Persona;
import com.example.covid.Model.Sintoma;
import com.example.covid.Service.IService;
import com.example.covid.Service.PersonaService;
import com.example.covid.Service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaController{

    private final PersonaService personaService;
    private final SintomaService sintomaService;

    @Autowired
    public PersonaController(PersonaService personaService, SintomaService sintomaService){
        this.personaService = personaService;
        this.sintomaService = sintomaService;
    }

    @GetMapping("/finPerson/{id}")
    public ResponseEntity<String> obtenerPersona(@PathVariable Integer id) {
        Persona persona = personaService.obtener(id);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        PersonaDTO personaDTO = new PersonaDTO(persona.getNombre()+" "+persona.getApellido());
        return ResponseEntity.ok(personaDTO.getNombreApellido());
    }

    @GetMapping ("/findPerson")
    public ResponseEntity<List<PersonaDTO>> obtenerAllPersonas(){
        List<Persona> listaPersona = personaService.obtenerTodos();
        List<PersonaDTO> listaPersonaDTO = new ArrayList<>();
        for(Persona persona : listaPersona){
            listaPersonaDTO.add(new PersonaDTO(persona.getNombre()+" "+persona.getApellido()));
        }
        return ResponseEntity.ok(listaPersonaDTO);
    }

    @PostMapping("/crearPersona")
    void crearSintoma(@RequestBody Persona persona){
        personaService.crear(persona);
        System.out.println("Persona creada exitosamente");
    }
    @GetMapping("/findRiskPerson")
    public List<PersonaXSintomaDTO> personaXSintomaDTO (){
        List<Persona> listaPersonas60 = personaService.obtenerEdad60();
        List<PersonaXSintomaDTO> personaXSintomaDTOS = new ArrayList<>();
        List<SintomaDTO> sintomaDTOS = new ArrayList<>();
        List<Sintoma> sintomas = sintomaService.obtenerTodos();
        for(Persona persona : listaPersonas60){
            PersonaDTO personaDTO = new PersonaDTO(persona.getNombre()+" "+persona.getApellido());
            for (Sintoma sintoma: sintomas){
                sintomaDTOS.add(new SintomaDTO(sintoma.getNivelDeGravedad(),sintoma.getNombre()));
            }
            personaXSintomaDTOS.add(new PersonaXSintomaDTO(personaDTO,sintomaDTOS));
        }
        return personaXSintomaDTOS;
    }
}
