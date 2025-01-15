package com.bootcamp.Movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieActorsDto {
    @JsonProperty("movie_title")
    String movieTitle;
    List<ActorDto> actors;
}
