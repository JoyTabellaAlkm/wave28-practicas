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
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Long id;

    @Column(unique = true, length = 500)
    String title;

    Integer number;

    @Column(nullable = false)
    LocalDateTime releaseDate;

    @Column(columnDefinition = "Decimal(3,1)", nullable = false)
    Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    Season season;

    @ManyToMany(mappedBy = "episodes")
    Set<Actor> actors;


    Timestamp createdAt;
    Timestamp updatedAt;
}
