package com.bootcamp.Movies.entity;

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
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Column(name = "title")
    private String title;
    @Column(name = "number")
    private Integer number;
    @Column(name = "release_date")
    private Timestamp releaseDate;
    @Column(name = "rating", columnDefinition = "DECIMAL(3,1)")
    private BigDecimal rating;
    @ManyToOne
    @JoinColumn(name="season_id")
    private Season season;
    @ManyToMany(mappedBy = "episodes")
    private Set<Actor> actors;
}
