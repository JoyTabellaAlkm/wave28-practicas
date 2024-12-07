package com.meli.starWares.repository;

import com.meli.starWares.model.PersonajeModel;

import java.io.IOException;
import java.util.List;

public interface IPersonajeRepository {
    public List<PersonajeModel> getAllPersonajes()throws IOException;
}
