package com.spring.ejercicios.services.impl;

import com.spring.ejercicios.dto.personaDTO;
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
            new Persona(1, 44, "Pérez", "Juan", List.of(2)),
            new Persona(2, 44, "González", "Ana"),
            new Persona(3, 44, "López", "Carlos", List.of(1, 2, 3))
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
    public List<personaDTO> personasRiesgo() {
        List<Persona> personas1 = personas.stream()
                .filter(x -> x.getEdad() >= 60 && !x.getSintomasCodigos().isEmpty())
                .toList();
        List<personaDTO> listaDto = new ArrayList<>();
        if (!personas1.isEmpty()){
            for(Persona p : personas1) {
                personaDTO pe = new personaDTO(p.getNombre(), p.getApellido());
                listaDto.add(pe);
            }
        }
        return listaDto;
    }
}
