package com.bootcamp.movies_api.service.impl;

import com.bootcamp.movies_api.dto.SimpleActorWithFavoriteMovieAndRatingDTO;
import com.bootcamp.movies_api.dto.SimpleActorWithRatingDTO;
import com.bootcamp.movies_api.model.Actor;
import com.bootcamp.movies_api.repository.ActorRepository;
import com.bootcamp.movies_api.service.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    ModelMapper modelMapper;
    ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ModelMapper modelMapper) {
        this.actorRepository = actorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SimpleActorWithFavoriteMovieAndRatingDTO> findByFavoriteMovieIsNotNull() {
        List<Actor> actors = actorRepository.findAllByFavoriteMovieIsNotNull();
        return actors
                .stream()
                .map(a -> modelMapper.map(a, SimpleActorWithFavoriteMovieAndRatingDTO.class))
                .toList();
    }

    @Override
    public List<SimpleActorWithRatingDTO> findByRatingGreaterThan(Double rating) {
        return actorRepository.findByRatingGreaterThan(rating)
                .stream()
                .map(a -> modelMapper.map(a, SimpleActorWithRatingDTO.class))
                .toList();
    }
}
