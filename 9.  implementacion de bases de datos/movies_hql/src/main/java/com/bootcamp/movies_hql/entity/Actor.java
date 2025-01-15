package com.bootcamp.movies_hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Actor {
    @Id
    Long id;
    Double rating;
    @ManyToOne
    Movie favouriteMovie;
    @ManyToMany
    List<Movie> movies;
    @ManyToMany
    List<Episode> episodes;
}
