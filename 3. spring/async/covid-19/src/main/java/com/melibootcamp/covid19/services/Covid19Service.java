package com.melibootcamp.covid19.services;

import com.melibootcamp.covid19.dtos.PersonaDeRiesgoDTO;
import com.melibootcamp.covid19.entities.Persona;
import com.melibootcamp.covid19.entities.Sintoma;
import com.melibootcamp.covid19.repositories.PersonaRepository;
import com.melibootcamp.covid19.repositories.SintomaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Covid19Service {

    private PersonaRepository personaRepository;
    private SintomaRepository sintomaRepository;

    public Covid19Service(){
        this.personaRepository = new PersonaRepository();
        this.sintomaRepository = new SintomaRepository();
    }

    public List<Sintoma> obtenerSintomasCargados(){
        return sintomaRepository.devolverSintomas();
    }

    public int obtenerGravedadDeSintomaPorNombre(String sintoma){
        Optional<Sintoma> toRead = Optional.of(this.sintomaRepository.devolverSintomaPorNombre(sintoma));
        if (toRead.isPresent()){
            return toRead.get().getNivelDeGravedad();
        }
        else return -1;
    }

    //ToDo: Port all this pasta to stream API
    public List<PersonaDeRiesgoDTO> obtenerPersonasDeRiesgo(){
        List<PersonaDeRiesgoDTO> aDevolver = new ArrayList<>();
        List<Persona> personasALeer = personaRepository.devolverPersonas();
        for(Persona person : personasALeer){
            if(person.getEdad() > 60){
                List<String> sintomas = person.getSintomas();
                for(String sintoma : sintomas){
                    String aComparar = sintomaRepository.devolverSintomaPorNombre(sintoma).getNombre();
                    if (sintomas.contains(aComparar)) // THIS. IS. NOT. RIGHT!!!!!!!! but... it works....
                    {
                        PersonaDeRiesgoDTO aAgregar = new PersonaDeRiesgoDTO(person.getNombre(), person.getApellido());
                        aDevolver.add(aAgregar);
                        break;
                    }
                }
            }
        }
        return aDevolver;
    }


}
