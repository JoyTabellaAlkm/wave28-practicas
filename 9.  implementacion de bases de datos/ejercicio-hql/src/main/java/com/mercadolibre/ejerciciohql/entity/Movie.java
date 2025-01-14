package com.mercadolibre.ejerciciohql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Long id;

    @Column(length = 500, nullable = false)
    String title;

    @Column(columnDefinition = "Decimal(3,1)", nullable = false)
    Double rating;

    @Column(nullable = false)
    Integer awards;

    @Column(nullable = false)
    LocalDateTime releaseDate;

    Integer length;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genre;

    @ManyToMany(mappedBy = "movies")
    Set<Actor> actors;

    Timestamp createdAt;
    Timestamp updatedAt;

}
