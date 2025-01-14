package com.bootcamp.movies_hql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Season {
    @Id
    Long id;
    @ManyToOne
    Serie serie;
    @OneToMany
    List<Episode> episodes;
}
