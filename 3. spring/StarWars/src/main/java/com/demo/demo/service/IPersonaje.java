package com.demo.demo.service;

import com.demo.demo.dto.PersonajeDTO;

import java.util.List;

public interface IPersonaje {
    public List<PersonajeDTO> buscarPersonaje(String nombre);
}
