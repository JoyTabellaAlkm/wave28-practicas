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
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column
    private String name;

    @Column
    private Integer ranking;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;

    @OneToMany(mappedBy = "genre")
    private List<Serie> series;
}
