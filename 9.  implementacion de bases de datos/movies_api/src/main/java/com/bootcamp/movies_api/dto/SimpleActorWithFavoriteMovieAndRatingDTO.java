package com.bootcamp.movies_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleActorWithFavoriteMovieAndRatingDTO {
    @JsonProperty("first_name")
    String firstName;
    @JsonProperty("last_name")
    String lastName;
    @JsonProperty("rating")
    Double rating;
    @JsonProperty("favorite_movie")
    MovieTitleAndRatingDTO favoriteMovie;
}
