package com.mercadolibre.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Long rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favoriteMovie;

    @ManyToMany
    @JoinTable(
            name="actor_movie",
            joinColumns = @JoinColumn (name = "actor_id"),
            inverseJoinColumns = @JoinColumn (name = "movie_id")
    )
    private List<Movie> movies;

    @ManyToMany
    @JoinTable(
            name="actor_episode",
            joinColumns = @JoinColumn (name = "actor_id"),
            inverseJoinColumns = @JoinColumn (name = "episode_id")
    )
    private List<Episode> episodes;
}
