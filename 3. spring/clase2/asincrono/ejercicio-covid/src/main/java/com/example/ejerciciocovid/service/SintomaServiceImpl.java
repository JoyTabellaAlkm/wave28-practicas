package com.example.ejerciciocovid.service;

import com.example.ejerciciocovid.dto.PersonaDto;
import com.example.ejerciciocovid.dto.SintomaDto;
import com.example.ejerciciocovid.model.Persona;
import com.example.ejerciciocovid.model.Sintoma;
import com.example.ejerciciocovid.repository.SintomaRepository;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;
@Service
public class SintomaServiceImpl implements ISintomaService{
    SintomaRepository repository = new SintomaRepository();
    List<Persona> personas = repository.personaData();
    List<Sintoma> sintomas = repository.sintomasData();
    @Override
    public List<Sintoma> obtenerSintomas() {
        return sintomas;
    }

    @Override
    public SintomaDto obtenerSintoma(String nombre) {
        Sintoma sintoma = sintomas.stream()
                .filter(x->x.getNombre().toUpperCase().equals(nombre.toUpperCase()))
                .findFirst()
                .orElse(null);
        if(sintoma == null){
            return null;
        }
        return mapearSintomaADto(sintoma);
    }

    private SintomaDto mapearSintomaADto(Sintoma sintoma){
        if (sintomas.size()<=0){
            return null;
        }
        SintomaDto sintomaDto = new SintomaDto(
                sintoma.getNombre(),
                sintoma.getNivelDeGravedad()
        );
        return sintomaDto;
    }

    @Override
    public List<PersonaDto> obtenerPersonasDeRiesgo() {
        List<Persona> personasRiesgo = personas.stream()
                .filter(x->x.getEdad()>=60)
                .filter(x->x.getSintomas().size()>=0)
                .toList();
        List<PersonaDto> personasRiesgoDto = personasRiesgo.stream()
                .map(this::mapearPersonaDto)
                .toList();
        return personasRiesgoDto;
    }
    private PersonaDto mapearPersonaDto(Persona persona){
        List<SintomaDto> sintomasDto = persona.getSintomas()
                .stream()
                .map(this::mapearSintomaADto)
                .toList();
        PersonaDto personaDto = new PersonaDto(persona.getNombre(), persona.getApellido(), sintomasDto);
        return personaDto;
    }
}
