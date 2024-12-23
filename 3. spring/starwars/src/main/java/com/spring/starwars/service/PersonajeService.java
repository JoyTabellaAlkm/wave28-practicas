package com.spring.starwars.service;

import com.spring.starwars.dto.PersonajeDTO;
import com.spring.starwars.model.Personaje;
import com.spring.starwars.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajeService {
    List<PersonajeDTO> findByName(String name);



}
