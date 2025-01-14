package com.mercadolibre.movies.dto;

import com.mercadolibre.movies.entity.Episode;
import com.mercadolibre.movies.entity.Genre;
import com.mercadolibre.movies.entity.Movie;
import com.mercadolibre.movies.entity.Season;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;

    public SerieDTO(Object[] obj) {
        this.id = (Long) obj[0];
        this.title = (String) obj[1];
        this.releaseDate = (LocalDate) obj[2];
        this.endDate = (LocalDate) obj[3];
    }
}
