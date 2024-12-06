package ar.com.mercadolibre.starwars.service;


import ar.com.mercadolibre.starwars.dto.PersonajeDTO;
import ar.com.mercadolibre.starwars.model.Personaje;

import java.util.List;

public interface IPersonajesService {
    public List<Personaje> findByName(String name);
}
