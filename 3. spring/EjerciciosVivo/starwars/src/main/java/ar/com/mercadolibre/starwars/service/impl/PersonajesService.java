package ar.com.mercadolibre.starwars.service.impl;

import ar.com.mercadolibre.starwars.dto.PersonajeDTO;
import ar.com.mercadolibre.starwars.model.Personaje;
import ar.com.mercadolibre.starwars.repository.PersonajeRepository;
import ar.com.mercadolibre.starwars.service.IPersonajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajesService implements IPersonajesService {
    @Autowired
    private PersonajeRepository personajeRepository;

    @Override
    public List<Personaje> findByName(String name) {
        return personajeRepository.readJson();
    }
}
