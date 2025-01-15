package com.bootcamp.Movies.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    private String title;
    @Column(name = "rating", columnDefinition = "DECIMAL(3,1)")
    private BigDecimal rating;
    private Integer awards;
    @Column(name = "release_date")
    private Timestamp releaseDate;
    private Integer length;
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;
    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;
}
