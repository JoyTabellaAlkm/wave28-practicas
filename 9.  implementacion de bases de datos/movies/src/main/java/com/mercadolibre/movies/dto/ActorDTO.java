package com.mercadolibre.movies.dto;

import com.mercadolibre.movies.entity.Episode;
import com.mercadolibre.movies.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String firstName;
    private String lastName;
    private Long rating;
    private Movie favoriteMovie;
    private List<Movie> movies;
    private List<Episode> episodes;

    public ActorDTO(Object[] obj) {
        this.id = (Long) obj[0];
        this.firstName = (String) obj[1];
        this.lastName = (String) obj[2];
        this.rating = (Long) obj[3];
    }
}
