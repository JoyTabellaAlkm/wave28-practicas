package com.bootcamp.movies_api.dto;

import com.bootcamp.movies_api.model.Genre;
import com.bootcamp.movies_api.model.Season;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieDTO {
    private Long id;
    private String title;
    @JsonProperty("release_date")
    private LocalDate releaseDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
    private SimpleGenreDTO genre;
    List<Season> seasons;
}
