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
@Table(name = "actors")
public class Actor {
    @Id
    int id;
    @Column(name = "created_at")
    LocalDate createdAt;
    @Column(name = "updated_at")
    LocalDate updatedAt;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    Double rating;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    Movie favoriteMovie;
    @JsonIgnore
    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;
}
