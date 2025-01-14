package com.mercadolibre.movies.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "actors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    @Column(name = "favorite_movie_id")
    private Integer favoriteMovieId;

    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private List<ActorEpisode> actorEpisodes;
}
