package org.moviesbd.service;

import org.moviesbd.entity.genres;
import org.moviesbd.repository.iMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieService implements iMovieService{

    @Autowired
    private iMoviesRepository repo;

    @Override
    public List<genres> find() {
        return repo.findAllByMoviesIsNotEmpty();
    }
}
