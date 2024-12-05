package com.example.ejerciciodeportistas.service;

import com.example.ejerciciodeportistas.model.Deporte;
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
    public Deporte listarDeportePorNombre(String nombre){
        Deporte deporte = listaDeportes.stream()
                .filter(d->d.getNombre().equals(nombre))
                .findFirst().orElseThrow(RuntimeException::new);
        return deporte;
    }






}
