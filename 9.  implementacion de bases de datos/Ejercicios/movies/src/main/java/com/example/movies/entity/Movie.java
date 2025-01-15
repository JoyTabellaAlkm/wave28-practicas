package com.example.movies.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "movies")
public class Movie {
    @Id
    int id;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    String title;
    double rating;
    int awards;
    @Column(name = "release_date")
    LocalDate releaseDate;
    Integer length;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;
    @JsonIgnore
    @OneToMany(mappedBy = "favoriteMovie")
    List<Actor> actoresFavorites;
    //Para tener la clase intermedia actor_movie
    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<ActorMovie> actorMovies;
}
