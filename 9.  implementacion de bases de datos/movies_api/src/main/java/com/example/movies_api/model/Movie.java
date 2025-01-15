package com.example.movies_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false)
    private Integer awards;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    private Integer length;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Actor> actorsFavorite;
}
