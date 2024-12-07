package com.meli.starWares.service;

import com.meli.starWares.dto.PersonajeDto;

import java.io.IOException;
import java.util.List;

public interface IPersonajeService {
    public List<PersonajeDto> getPersonajesByName(String name)throws IOException;
}