package com.mercadolibre.movies.service;

import com.mercadolibre.movies.dto.ActorDTO;
import com.mercadolibre.movies.repository.IActorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{

    @Autowired
    private IActorRepository actorRepository;

    @Override
    public List<ActorDTO> getActorsWithFavoriteMovie() {
        List<Object[]> actors =  actorRepository.getActorsWithFavoriteMovie();
        return actors.stream().map(ActorDTO::new).toList();
    }

    @Override
    public List<ActorDTO> getActorsWithRating(Long rating) {
        List<Object[]> actors =  actorRepository.getActorsWithRating(rating);
        return actors.stream().map(ActorDTO::new).toList();
    }

    @Override
    public List<ActorDTO> getActorsFromMovie(String movie) {
        List<Object[]> actors =  actorRepository.getActorsFromMovie(movie);
        return actors.stream().map(ActorDTO::new).toList();
    }
}
