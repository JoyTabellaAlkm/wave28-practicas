package com.bootcamp.Movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;
    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;
    @Column(name = "name")
    private String name;
    @Column(name = "ranking")
    private Integer ranking;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(mappedBy = "genre")
    private Set<Movie> movies;
    @OneToMany(mappedBy = "genre")
    private Set<Serie> series;
}
