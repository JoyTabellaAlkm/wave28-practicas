package com.bootcamp.Movies.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "rating", columnDefinition = "DECIMAL(3,1)")
    private BigDecimal rating;
    @ManyToOne
    @JoinColumn(name="favorite_movie_id")
    private Movie favouriteMovie;
    @ManyToMany
    @JoinTable(name="actor_movie",
               joinColumns = @JoinColumn(name = "actor_id"),
               inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> movies;
    @ManyToMany
    @JoinTable(name="actor_episode",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "episode_id"))
    private Set<Episode> episodes;

    @JsonProperty("favourite_movie_title")
    private String getFavouriteMovieTitle() {
        return this.favouriteMovie.getTitle();
    }
}
