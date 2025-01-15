package com.example.movies_api.service.impl;

import com.example.movies_api.dto.RequestActorsDto;
import com.example.movies_api.model.Actor;
import com.example.movies_api.model.Episode;
import com.example.movies_api.model.Movie;
import com.example.movies_api.model.Series;
import com.example.movies_api.repository.ActorsRepository;
import com.example.movies_api.repository.EpisodesRepository;
import com.example.movies_api.repository.MoviesRepository;
import com.example.movies_api.repository.SeriesRepository;
import com.example.movies_api.service.IActorsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorsService implements IActorsService {
    @Autowired
    private ActorsRepository actorsRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private EpisodesRepository episodesRepository;

    @Override
    public List<Actor> getWithFavourites() {
        return actorsRepository.findByMovieIsNotNull();
    }

    @Override
    public List<Actor> getWithRatingGreaterThan(Double ratingIsGreaterThan) {
        return actorsRepository.findByRatingGreaterThan(ratingIsGreaterThan);
    }

    @Override
    public Actor create(RequestActorsDto requestActorsDto) {
        Optional<Movie> favoriteMovie = moviesRepository.findById(requestActorsDto.getFavoriteMovieId());

        if (favoriteMovie.isEmpty()) {
            throw new RuntimeException("No se encontro la pelicula favorita del actor");
        }

        List<Movie> movies =  moviesRepository.findAllById(requestActorsDto.getMovieIds());
        List<Episode> episodes = episodesRepository.findAllById(requestActorsDto.getEpisodesIds());

        ModelMapper modelMapper = new ModelMapper();
        Actor actorTosave = modelMapper.map(requestActorsDto, Actor.class);

        actorTosave.setMovie(favoriteMovie.get());
        actorTosave.setMovies(movies);
        actorTosave.setEpisodes(episodes);

        return actorsRepository.save(actorTosave);
    }
}
