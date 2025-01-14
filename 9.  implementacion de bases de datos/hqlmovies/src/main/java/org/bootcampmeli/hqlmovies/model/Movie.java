package org.bootcampmeli.hqlmovies.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("movie_id")
    private Long id;
    @Column(name = "created_at")
    @JsonProperty("created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    @JsonProperty("updated_at")
    private LocalDate updatedAt;
    @Column(nullable = false)
    @JsonProperty("title")
    String title;
    @Column(nullable = false)
    @JsonProperty("rating")
    Double rating;
    @Column(name = "awards", nullable = false)
    @JsonProperty("amount_of_awards")
    Integer amountOfAwards;
    @JsonProperty("release_date")
    @Column(name = "release_date", nullable = false)
    LocalDate releaseDate;
    @Column
    @JsonProperty("length")
    Integer length;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    @JsonProperty("genre")
    Genre genre;
}
