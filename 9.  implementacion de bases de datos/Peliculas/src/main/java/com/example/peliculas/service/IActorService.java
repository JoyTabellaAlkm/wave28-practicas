package com.example.peliculas.service;

import com.example.peliculas.dto.ActorDTO;
import com.example.peliculas.dto.MessageDTO;

import java.util.List;

public interface IActorService {


    List<ActorDTO> getAllActores();
    ActorDTO getActorById(Long id);

    void create(ActorDTO actorDTO);
}
