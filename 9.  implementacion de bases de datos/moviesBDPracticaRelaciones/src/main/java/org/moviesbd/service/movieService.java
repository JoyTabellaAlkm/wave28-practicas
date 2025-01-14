package org.moviesbd.service;

import org.moviesbd.entity.*;
import org.moviesbd.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService implements iMovieService{

    @Autowired
    private iGenreRepository repoGenre;

    @Autowired
    private iActorRepository repoActor;

    @Autowired
    private iMovieRepository repoMovies;

    @Autowired
    private iSerieRepository repoSerie;

    @Autowired
    private iEpisodeRepository repoEpisode;

    @Override
    public List<genres> find() {
        return repoGenre.findAllByMoviesIsNotEmpty();
    }

    @Override
    public List<actors> favoriteMovie() { return repoActor.findAllByMovieNotNull(); }

    @Override
    public List<actors> raitingGraterThan(float nro) { return repoActor.findAllByRatingGreaterThan(nro); }

    @Override
    public List<actors> workIn(String name) { return repoActor.workIn(name); }

    @Override
    public List<movies> actorsRaiting(float valor) { return repoMovies.moviesActorsRaiting(valor); }

    @Override
    public List<movies> moviesGenres(String titulo) { return repoMovies.moviesGenero(titulo); }

    @Override
    public List<series> seriesSeasons(int seasons) { return repoSerie.seasonsGraterThan(seasons); }

    @Override
    public List<episodes> episodesActor(String actor) { return repoEpisode.episodesActor(actor); }
}
