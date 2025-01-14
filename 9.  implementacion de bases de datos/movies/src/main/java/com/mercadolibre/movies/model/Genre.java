package com.mercadolibre.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "genres")
@Setter
@Getter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer ranking;
    private Boolean active;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;

    @OneToMany(mappedBy = "genre")
    private List<Series> series;
}
