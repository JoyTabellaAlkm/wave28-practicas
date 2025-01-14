package com.mercadolibre.movies.dto;

import com.mercadolibre.movies.entity.Actor;
import com.mercadolibre.movies.entity.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Long rating;
    private Integer awards;
    private Integer length;
    private LocalDate releaseDate;
    private Genre genre;
    private List<Actor> favoriteMovieActors;
    private List<Actor> actors;

    public MovieDTO(Object[] obj) {
        this.id = (Long) obj[0];
        this.title = (String) obj[1];
        this.rating = (Long) obj[2];
        this.awards = (Integer) obj[3];
        this.length = (Integer) obj[4];
        this.releaseDate = (LocalDate) obj[5];
    }

}
