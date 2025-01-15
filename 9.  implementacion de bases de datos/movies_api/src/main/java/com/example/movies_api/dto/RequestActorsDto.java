package com.example.movies_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestActorsDto {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("favorite_movie_id")
    private Integer favoriteMovieId;

    @JsonProperty("movie_ids")
    private List<Integer> movieIds;

    @JsonProperty("episodes_ids")
    private List<Integer> episodesIds;
}
