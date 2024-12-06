package com.starwars.spring.service;

import com.starwars.spring.dto.PersonajeDTO;

import java.util.ArrayList;

public interface IPersonajeService {

    ArrayList<PersonajeDTO> findByName(String name);
}
