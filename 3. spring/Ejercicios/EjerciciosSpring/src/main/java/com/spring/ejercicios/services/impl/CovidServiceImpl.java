package com.spring.ejercicios.services.impl;

import com.spring.ejercicios.dto.personaDto;
import com.spring.ejercicios.models.Persona;
import com.spring.ejercicios.models.Sintoma;
import com.spring.ejercicios.services.iCovidService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidServiceImpl implements iCovidService {

    private List<Sintoma> sintomas = List.of(
            new Sintoma(1, "Dolor de cabeza", 3),
            new Sintoma(2, "Fiebre", 2),
            new Sintoma(3, "Tos seca", 1)
    );

    private List<Persona> personas = List.of(
            new Persona(1, 67, "Pérez", "Juan", List.of(2)),  // Persona 1 con síntomas 1 y 3
            new Persona(2, 70, "González", "Ana"),    // Persona 2 con síntoma 2
            new Persona(3, 60, "López", "Carlos", List.of(1, 2, 3)) // Persona 3 con síntomas 1, 2 y 3
    );

    @Override
    public String existeSintoma(String name) {
        Sintoma sintomaEncontrado = sintomas.stream()
                .filter(x -> x.getNombre().equals(name))
                .findFirst()
                .orElse(null);
        String res= "No se encontro resultado";
        if(sintomaEncontrado != null){
            res = "El nivel de gravedad del sintoma " + name + " es " + sintomaEncontrado.getNivelGravedad();
        }

        return res;
    }

    @Override
    public List<Sintoma> todosSintomas() {
        return sintomas;
    }

    @Override
    public List<personaDto> personasRiesgo() {
        List<Persona> personas1 = personas.stream()
                .filter(x -> x.getEdad() >= 60 && !x.getSintomasCodigos().isEmpty())
                .toList();
        List<personaDto> listaDto = new ArrayList<>();
        if (!personas1.isEmpty()){
            for(Persona p : personas1) {
                personaDto pe = new personaDto(p.getNombre(), p.getApellido());
                listaDto.add(pe);
            }
        }
        return listaDto;
    }
}
