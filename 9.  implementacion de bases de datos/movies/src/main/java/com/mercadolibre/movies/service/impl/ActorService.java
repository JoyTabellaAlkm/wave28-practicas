package com.mercadolibre.movies.service.impl;

import com.mercadolibre.movies.dto.ActorDto;
import com.mercadolibre.movies.model.Actor;
import com.mercadolibre.movies.repository.IActorRepository;
import com.mercadolibre.movies.service.IActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService implements IActorService {
    @Autowired
    IActorRepository actorRepository;

    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ActorDto> obtenerActoresConPeliculaFavorita() {
        return actorRepository.findActorsByFavoriteMovieIdExists()
                .stream()
                .map(actor->modelMapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> obtenerActoresPorRatingMayor(BigDecimal rating) {
        return actorRepository.findActorsByRatingAfterParam(rating)
                .stream()
                .map(actor->modelMapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> obtenerActoresPorPelicula(String movieTitle) {
        return actorRepository.findActorsByNameMovie(movieTitle)
                .stream()
                .map(actor->modelMapper.map(actor, ActorDto.class))
                .toList();
    }
}
