package com.example.peliculas.service;

import com.example.peliculas.Exception.NotFoundException;
import com.example.peliculas.dto.ActorDTO;
import com.example.peliculas.entity.Actor;
import com.example.peliculas.repository.ActorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorServiceImpl implements IActorService{

    private ObjectMapper objectMapper;
    private ModelMapper modelMapper;
    private ActorRepository actorRepository;


    public ActorServiceImpl(ObjectMapper objectMapper, ModelMapper modelMapper, ActorRepository actorRepository) {
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> getAllActores() {
        return actorRepository.findAll().stream().
                map(a-> objectMapper.convertValue(a, ActorDTO.class))
                .toList();
    }

    @Override
    public ActorDTO getActorById(Long id) {
        return actorRepository.findById(id)
                .map(actor -> objectMapper.convertValue(actor, ActorDTO.class))
                .orElseThrow(() -> new NotFoundException("No se encontró el usuario con id: " + id));
    }

    @Override
    public void create(ActorDTO actorDTO) {
        Actor actor = modelMapper.map(actorDTO, Actor.class);
        actorRepository.save(actor);
    }


}
