package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDTO> getPersonajesByName(String name)throws IOException;
}
