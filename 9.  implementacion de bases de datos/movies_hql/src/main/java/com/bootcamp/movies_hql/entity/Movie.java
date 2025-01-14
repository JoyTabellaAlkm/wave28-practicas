package com.bootcamp.movies_hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Movie {
    @Id
    Long id;
    @ManyToMany
    List<Actor> actors;
    @ManyToOne
    Genre genre;
}
