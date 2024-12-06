package com.mercadolibre.starwars.service.impl;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import com.mercadolibre.starwars.model.Personaje;
import com.mercadolibre.starwars.repository.ICRUDRepository;
import com.mercadolibre.starwars.service.IPersonaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonajeImpl implements IPersonaje {
    @Autowired
    private ICRUDRepository<Personaje> personajeRepository;

    @Override
    public List<PersonajeDTO> buscar(String nombrePesonaje) {
        return convertirModelADto(personajeRepository.buscarPorNombre(nombrePesonaje));
    }

    private List<PersonajeDTO> convertirModelADto(List<Personaje> personajesModel){
        return personajesModel.stream().map(x->new PersonajeDTO(x.getName(),x.getHeight()
                ,x.getMass(),x.getGender(),x.getHomeworld(), x.getSpecies())).toList();
    }
}
