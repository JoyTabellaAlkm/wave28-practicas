package com.clothes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    @LastModifiedDate
    private LocalDate updatedAt;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToMany(mappedBy = "actorMovie")
    private Set<Movie> movies;


    @ManyToMany(mappedBy = "actorEpisode")
    private Set<Episode> episodes;

    @ManyToOne
    @JoinColumn(name = "movie_favorite_id", nullable = false)
    private Movie movie;
}
