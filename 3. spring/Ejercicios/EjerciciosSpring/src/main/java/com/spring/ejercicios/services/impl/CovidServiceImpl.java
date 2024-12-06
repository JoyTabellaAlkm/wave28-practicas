package com.spring.ejercicios.services.impl;

import com.spring.ejercicios.dto.PersonaCovidDTO;
import com.spring.ejercicios.models.PersonaCovid;
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

    private List<PersonaCovid> personas = List.of(
            new PersonaCovid(1, 44, "Pérez", "Juan", List.of(2)),
            new PersonaCovid(2, 44, "González", "Ana"),
            new PersonaCovid(3, 44, "López", "Carlos", List.of(1, 2, 3))
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
    public List<PersonaCovidDTO> personasRiesgo() {
        List<PersonaCovid> personas1 = personas.stream()
                .filter(x -> x.getEdad() >= 60 && !x.getSintomasCodigos().isEmpty())
                .toList();
        List<PersonaCovidDTO> listaDto = new ArrayList<>();
        if (!personas1.isEmpty()){
            for(PersonaCovid p : personas1) {
                PersonaCovidDTO pe = new PersonaCovidDTO(p.getNombre(), p.getApellido());
                listaDto.add(pe);
            }
        }
        return listaDto;
    }
}
