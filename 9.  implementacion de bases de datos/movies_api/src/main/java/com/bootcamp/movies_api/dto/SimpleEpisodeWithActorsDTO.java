package com.bootcamp.movies_api.dto;

import com.bootcamp.movies_api.model.Actor;
import com.bootcamp.movies_api.model.Serie;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleEpisodeWithActorsDTO {
    Long id;
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;
    List<SimpleActorWithRatingDTO> actors;
}
