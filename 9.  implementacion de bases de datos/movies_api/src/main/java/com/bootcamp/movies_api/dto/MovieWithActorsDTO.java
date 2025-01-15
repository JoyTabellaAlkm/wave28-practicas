package com.bootcamp.movies_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieWithActorsDTO {
    Long id;
    String title;
    Double rating;
    List<SimpleActorWithRatingDTO> actors;
}
