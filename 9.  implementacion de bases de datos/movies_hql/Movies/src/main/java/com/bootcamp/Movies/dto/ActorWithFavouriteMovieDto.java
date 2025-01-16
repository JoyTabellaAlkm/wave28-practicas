package com.bootcamp.Movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActorWithFavouriteMovieDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("rating")
    private BigDecimal rating;
    @JsonProperty("favourite_movie_title")
    private String favouriteMovieTitle;
}
