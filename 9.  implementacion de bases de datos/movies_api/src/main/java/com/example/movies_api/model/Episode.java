package com.example.movies_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

    @Column
    private String title;

    @Column
    private Integer number;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private Double rating;

    @ManyToMany(mappedBy = "episodes")
    private List<Actor> actors;
}
