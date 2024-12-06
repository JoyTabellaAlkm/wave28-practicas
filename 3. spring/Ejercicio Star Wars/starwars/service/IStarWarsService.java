package com.example.starwars.service;


import com.example.starwars.dto.PersonajeDTO;
import com.example.starwars.repository.StarWarsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IStarWarsService {

    List<PersonajeDTO> getPersonajesByName(String nombre);



}
