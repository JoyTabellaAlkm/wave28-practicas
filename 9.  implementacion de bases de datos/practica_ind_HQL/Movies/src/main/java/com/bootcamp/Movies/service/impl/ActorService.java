package com.bootcamp.Movies.service.impl;

import com.bootcamp.Movies.dto.ActorDto;
import com.bootcamp.Movies.dto.ActorWithFavouriteMovieDto;
import com.bootcamp.Movies.repository.IActorRepository;
import com.bootcamp.Movies.service.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private final IActorRepository actorRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorWithFavouriteMovieDto> getActorsHavingFavouriteMovie() {
        return actorRepository.findActorsWithFavouriteMovie().stream()
                .map(actor -> modelMapper.map(actor, ActorWithFavouriteMovieDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> getActorsHavingRatingGreaterThan(double rating) {
        return actorRepository.findActorsByRatingIsGreaterThan(rating);
    }
}
