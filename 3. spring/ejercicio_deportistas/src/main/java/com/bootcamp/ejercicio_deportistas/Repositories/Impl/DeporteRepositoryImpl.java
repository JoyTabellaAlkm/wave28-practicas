package com.bootcamp.ejercicio_deportistas.Repositories.Impl;

import com.bootcamp.ejercicio_deportistas.Models.Deporte;
import com.bootcamp.ejercicio_deportistas.Models.Persona;
import com.bootcamp.ejercicio_deportistas.Repositories.IDeporteRepository;

import java.util.List;

public class DeporteRepositoryImpl implements IDeporteRepository {
    List<Deporte> listaDeportes = List.of(
            new Deporte(1, "Fútbol", "Media"),
            new Deporte(2, "Baloncesto", "Alta"),
            new Deporte(3, "Polo", "Alta"),
            new Deporte(4, "Tenis", "Media"),
            new Deporte(5, "Natación", "Baja")
    );
    @Override
    public List<Deporte> buscartodos() {
        return listaDeportes;
    }

    @Override
    public Deporte buscarPorNombre(String nombre) {
        Deporte deporte =
                listaDeportes.stream().filter(per -> per.getNombre().equals(nombre)).findFirst().get();
        if (deporte == null) {
            throw new RuntimeException("Persona no encontrado");
        }
        return deporte;
    }
}

