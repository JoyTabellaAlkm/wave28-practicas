package org.moviesbd.service;

import org.moviesbd.entity.*;

import java.util.List;
import java.util.ListResourceBundle;

public interface iMovieService {
    public List<genres> find ();

    public List<actors> favoriteMovie();

    public List<actors> raitingGraterThan(float nro);

    public List<actors> workIn(String name);

    public List<movies> actorsRaiting(float valor);

    public List<movies> moviesGenres(String titulo);

    public List<series> seriesSeasons(int seasons);

    public List<episodes> episodesActor(String actor);
}
