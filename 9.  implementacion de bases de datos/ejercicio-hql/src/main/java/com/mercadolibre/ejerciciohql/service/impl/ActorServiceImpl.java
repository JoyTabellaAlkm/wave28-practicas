package com.mercadolibre.ejerciciohql.service.impl;

import com.mercadolibre.ejerciciohql.dto.ActorDTO;
import com.mercadolibre.ejerciciohql.entity.Actor;
import com.mercadolibre.ejerciciohql.exception.NotFoundException;
import com.mercadolibre.ejerciciohql.repository.IActorRepository;
import com.mercadolibre.ejerciciohql.service.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActorServiceImpl implements IActorService {

    IActorRepository actorRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public ActorDTO findActorById(Long id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Actor no encontrado"));

        return modelMapper.map(actor, ActorDTO.class);
    }

    @Override
    public List<ActorDTO> getAllActors() {
        List<Actor> actors = (List<Actor>) actorRepository.findAll();
        return actorListToActorDTOList(actors);
    }

    @Override
    public List<ActorDTO> findActorsThatHaveFavoriteMovie() {
        List<Actor> actors = actorRepository.findActorsThatHaveFavoriteMovie();
        return actorListToActorDTOList(actors);

    }

    @Override
    public List<ActorDTO> findActorsWhereRatingHigherThanGiven(Double rating) {
        List<Actor> actors = actorRepository.findActorsWhereRatingHigherThanGiven(rating);
        return actorListToActorDTOList(actors);
    }

    @Override
    public List<ActorDTO> findActorsByMovieId(Long id) {
        List<Actor> actors = actorRepository.findActorsByMovieId(id);
        return actorListToActorDTOList(actors);
    }


    /**
     *
     * @param actors Lista de Actor
     * @return Lista de ActorDTO
     */
    private List<ActorDTO> actorListToActorDTOList(List<Actor> actors) {
        return actors
                .stream()
                .map(a -> modelMapper.map(a, ActorDTO.class))
                .toList();
    }

}
