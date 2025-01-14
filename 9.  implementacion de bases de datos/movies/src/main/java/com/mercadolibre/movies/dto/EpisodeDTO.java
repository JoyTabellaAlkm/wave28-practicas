package com.mercadolibre.movies.dto;

import com.mercadolibre.movies.entity.Actor;
import com.mercadolibre.movies.entity.Season;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {

    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private LocalDate endDate;

    public EpisodeDTO(Object[] obj) {
        this.id = (Long) obj[0];
        this.title = (String) obj[1];
        this.number = (Integer) obj[2];
        this.releaseDate = (LocalDate) obj[3];
        this.endDate = (LocalDate) obj[4];
    }
}
