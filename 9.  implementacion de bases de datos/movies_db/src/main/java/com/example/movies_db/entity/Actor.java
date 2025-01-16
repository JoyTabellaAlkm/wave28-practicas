package com.example.movies_db.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "first_name",length = 100)
    String firstName;
    @Column(name = "last_name",length = 100)
    String lastName;
    @Column(precision = 3,scale = 1)
    BigDecimal rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie")
    Movie favorite_movie;


    @ManyToMany(mappedBy = "actors_episodes")
    Set<Episode> episodes;

    @ManyToMany(mappedBy = "actors_movies")
    Set<Movie> movies;
}
