package com.bootcamp.ejercicio_deportistas.Repositories;

import com.bootcamp.ejercicio_deportistas.Models.Persona;

import java.util.List;

public interface IPersonaRepository {

    public void guardar(Persona props);


    public Persona buscarPorId(Integer id);


    public List<Persona> buscartodos();


    public void eliminar(Integer id);
}
