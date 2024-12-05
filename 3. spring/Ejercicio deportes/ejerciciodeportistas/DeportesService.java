package com.example.ejerciciodeportistas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportesService {

    List<Deporte> listaDeportes = new ArrayList<>(List.of( new Deporte("Ping pong", "avanzado"),
            new Deporte("fulbo", "intermedio"),
            new Deporte("tenis", "principiante"))
            );

    public List<Deporte> listarDeportes(){
        return listaDeportes;
    }
    public Optional<Deporte> listarDeportePorNombre(String nombre){
        Optional<Deporte> deporte = listaDeportes.stream().filter(d->d.getNombre().equals(nombre)).findFirst();
        return deporte;
    }






}
