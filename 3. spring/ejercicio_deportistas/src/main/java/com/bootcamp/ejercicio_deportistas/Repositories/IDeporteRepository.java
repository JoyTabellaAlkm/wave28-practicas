package com.bootcamp.ejercicio_deportistas.Repositories;

import com.bootcamp.ejercicio_deportistas.Models.Deporte;

import java.util.List;

public interface IDeporteRepository {
    public List<Deporte> buscartodos();
    public Deporte buscarPorNombre(String nombre);


}
